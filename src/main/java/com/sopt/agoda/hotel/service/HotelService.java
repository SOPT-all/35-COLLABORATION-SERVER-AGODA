package com.sopt.agoda.hotel.service;

import com.sopt.agoda.hotel.controller.dto.res.HotelInfo;
import com.sopt.agoda.hotel.controller.dto.res.HotelListRes;
import com.sopt.agoda.hotel.domain.Hotel;
import com.sopt.agoda.hotel.enums.SaleType;
import com.sopt.agoda.hotel.repository.HotelImageRepository;
import com.sopt.agoda.hotel.repository.HotelRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelImageRepository hotelImageRepository;

    public HotelService(HotelRepository hotelRepository, HotelImageRepository hotelImageRepository) {
        this.hotelRepository = hotelRepository;
        this.hotelImageRepository = hotelImageRepository;
    }

    public HotelListRes getHotelList(final SaleType saleType, final Long cityId) {
        List<Hotel> allHotels;

        if (saleType == SaleType.TIME_LIMIT) {
            allHotels = hotelRepository.findByCityId(cityId);
        } else {
            allHotels = hotelRepository.findByCityIdAndIsTimeSaleFalse(cityId);
        }

        final List<Long> hotelIds = allHotels.stream()
                .map(Hotel::getId)
                .toList();
        final List<Object[]> firstImages = hotelImageRepository.findFirstImagesForHotels(hotelIds);

        final Map<Long, String> hotelIdToImageUrl = firstImages.stream()
                .collect(Collectors.toMap(
                        obj -> ((Number) obj[0]).longValue(),
                        obj -> (String) obj[1]
                ));

        final List<HotelInfo> hotelInfos = allHotels.stream()
                .map(hotel -> {
                    String imageUrl = hotelIdToImageUrl.get(hotel.getId());
                    return HotelInfo.of(hotel, imageUrl);
                })
                .toList();

        return HotelListRes.of(hotelInfos);
    }
}
