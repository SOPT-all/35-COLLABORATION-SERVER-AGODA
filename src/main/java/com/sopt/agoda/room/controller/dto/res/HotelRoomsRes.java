package com.sopt.agoda.room.controller.dto.res;

import java.util.List;

public record HotelRoomsRes(List<HotelRoomInfo> rooms) {
    public static HotelRoomsRes of(final List<HotelRoomInfo> rooms) {
        return new HotelRoomsRes(rooms);
    }
}
