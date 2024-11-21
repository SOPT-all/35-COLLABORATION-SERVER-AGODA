package com.sopt.agoda.hotel.service;

import com.sopt.agoda.common.exception.AgodaException;
import com.sopt.agoda.common.response.message.FailMessage;
import com.sopt.agoda.common.util.ValidatorUtils;
import com.sopt.agoda.hotel.controller.dto.res.HotelDetailImage;
import com.sopt.agoda.hotel.controller.dto.res.HotelDetailRes;
import com.sopt.agoda.hotel.controller.dto.res.HotelInfo;
import com.sopt.agoda.hotel.controller.dto.res.HotelListRes;
import com.sopt.agoda.hotel.domain.Hotel;
import com.sopt.agoda.hotel.domain.HotelImage;
import com.sopt.agoda.hotel.enums.SaleType;
import com.sopt.agoda.hotel.repository.HotelImageRepository;
import com.sopt.agoda.hotel.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

        if (saleType == SaleType.DEFAULT) {
            allHotels = hotelRepository.findByCityIdAndIsTimeSaleFalse(cityId);
        } else {
            allHotels = hotelRepository.findByCityId(cityId);
        }

        if (ValidatorUtils.isEmptyList(allHotels)) {
            throw new AgodaException(FailMessage.NOT_FOUND_HOTELS);
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

    public HotelDetailRes getHotelDetail(final Long hotelId) {
        final Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new AgodaException(FailMessage.NOT_FOUND_HOTEL));

        List<HotelImage> hotelImages = hotelImageRepository.findByHotelIdOrderByHotelImageId(hotelId);

        List<HotelDetailImage> hotelDetailImages = hotelImages.stream()
                .map(image -> new HotelDetailImage(image.getId(), image.getImageUrl()))
                .toList();

        if (ValidatorUtils.isEmptyList(hotelDetailImages)) {
            throw new AgodaException(FailMessage.NOT_FOUND_HOTEL_IMAGES);
        }

        return HotelDetailRes.of(
                hotel.getId(), hotel.isLiked(), hotel.getHotelName(), hotel.getStar(),
                hotel.getReviewCount(), hotelDetailImages
                );
    }

    @Transactional
    public void patchHotelLike(final Long hotelId, final boolean isLiked) {
        Hotel foundHotel = hotelRepository.findById(hotelId).orElseThrow(
                () -> new AgodaException(FailMessage.NOT_FOUND_HOTEL)
        );
        foundHotel.setLiked(isLiked);
    }
}
