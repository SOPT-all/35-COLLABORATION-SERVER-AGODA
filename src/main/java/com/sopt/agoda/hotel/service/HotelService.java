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
import com.sopt.agoda.room.controller.dto.res.HotelRoomImage;
import com.sopt.agoda.room.controller.dto.res.HotelRoomInfo;
import com.sopt.agoda.room.controller.dto.res.HotelRoomsRes;
import com.sopt.agoda.room.domain.Room;
import com.sopt.agoda.room.domain.RoomImage;
import com.sopt.agoda.room.repository.RoomImageRepository;
import com.sopt.agoda.room.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelImageRepository hotelImageRepository;
    private final RoomRepository roomRepository;
    private final RoomImageRepository roomImageRepository;

    public HotelService(HotelRepository hotelRepository, HotelImageRepository hotelImageRepository, RoomRepository roomRepository, RoomImageRepository roomImageRepository) {
        this.hotelRepository = hotelRepository;
        this.hotelImageRepository = hotelImageRepository;
        this.roomRepository = roomRepository;
        this.roomImageRepository = roomImageRepository;
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

        final List<HotelImage> hotelImages = hotelImageRepository.findByHotelIdOrderByHotelImageId(hotelId);

        if (ValidatorUtils.isEmptyList(hotelImages)) {
            throw new AgodaException(FailMessage.NOT_FOUND_HOTEL_IMAGES);
        }

        final List<HotelDetailImage> hotelDetailImages = hotelImages.stream()
                .map(image -> new HotelDetailImage(image.getId(), image.getImageUrl()))
                .toList();

        return HotelDetailRes.of(
                hotel.getId(), hotel.isLiked(), hotel.getHotelName(), hotel.getStar(),
                hotel.getReviewCount(), hotelDetailImages
                );
    }

    public HotelRoomsRes getHotelRoomList(final Long hotelId) {
        final List<Room> rooms = roomRepository.findByHotelId(hotelId);

        if (ValidatorUtils.isEmptyList(rooms)) {
            throw new AgodaException(FailMessage.NOT_FOUND_ROOM);
        }

        final List<Long> roomIds = rooms.stream()
                .map(Room::getId)
                .toList();

        final List<RoomImage> roomImageList = roomImageRepository.findByRoomIdInOrderById(roomIds);

        if (ValidatorUtils.isEmptyList(roomImageList)) {
            throw new AgodaException(FailMessage.NOT_FOUND_ROOM_IMAGES);
        }

        List<HotelRoomInfo> hotelRoomInfoList = rooms.stream().map(room -> {
            List<HotelRoomImage> imagesForRoom = roomImageList.stream()
                    .filter(roomImage -> roomImage.getRoomId().equals(room.getId()))
                    .map(roomImage -> new HotelRoomImage(
                            roomImage.getId(),
                            roomImage.getImageUrl()
                    )).toList();

            return new HotelRoomInfo(
                    room.getId(),
                    room.getName(),
                    room.getSpaceSize(),
                    room.getBedType(),
                    room.getBedCount(),
                    room.getBathInfo(),
                    room.getMaxCapacity(),
                    imagesForRoom
            );
        }).toList();

        return HotelRoomsRes.of(hotelRoomInfoList);
    }
      
    @Transactional
    public void patchHotelLike(final Long hotelId, final boolean isLiked) {
        Hotel foundHotel = hotelRepository.findById(hotelId).orElseThrow(
                () -> new AgodaException(FailMessage.NOT_FOUND_HOTEL)
        );
        foundHotel.setLiked(isLiked);
    }
}
