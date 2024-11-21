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

    public static class Builder {
        private Long hotelImageId;
        private String hotelImageUrl;

        public Builder hotelImageId(final Long hotelImageId) {
            this.hotelImageId = hotelImageId;
            return this;
        }

        public Builder hotelImageUrl(final String hotelImageUrl) {
            this.hotelImageUrl = hotelImageUrl;
            return this;
        }

        public HotelDetailImage build() {
            return new HotelDetailImage(hotelImageId, hotelImageUrl);
        }
    }
}
