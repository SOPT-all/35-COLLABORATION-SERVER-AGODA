package com.sopt.agoda.hotel.controller.dto.res;

public record HotelDetailImage(
        Long hotelImageId,
        String hotelImageUrl
) {
    public static HotelDetailImage of (final Long hotelImageId, final String hotelImageUrl) {
        return new Builder()
                .hotelImageId(hotelImageId)
                .hotelImageUrl(hotelImageUrl)
                .build();
    }

    private static class Builder {
        private Long hotelImageId;
        private String hotelImageUrl;

        private Builder hotelImageId(final Long hotelImageId) {
            this.hotelImageId = hotelImageId;
            return this;
        }

        private Builder hotelImageUrl(final String hotelImageUrl) {
            this.hotelImageUrl = hotelImageUrl;
            return this;
        }

        private HotelDetailImage build() {
            return new HotelDetailImage(hotelImageId, hotelImageUrl);
        }
    }
}
