package com.sopt.agoda.hotel.controller.dto.res;

import java.util.List;

public record HotelListRes(
        List<HotelInfo> hotels
) {
    public static HotelListRes of (final List<HotelInfo> hotels) {
        return new HotelListRes((hotels));
    }
}
