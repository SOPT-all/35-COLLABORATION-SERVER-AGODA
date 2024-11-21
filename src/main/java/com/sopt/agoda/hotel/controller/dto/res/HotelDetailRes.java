package com.sopt.agoda.hotel.controller.dto.res;

import java.util.List;

public record HotelDetailRes(
        Long hotelId,
        Boolean isLiked,
        String hotelName,
        Number star,
        Number reservationCount,
        List<HotelDetailImage> hotelImages
) {
    public static HotelDetailRes of (final Long hotelId, final Boolean isLiked, final String hotelName, final Number star, final Number reservationCount, List<HotelDetailImage> hotelImages) {
        return new Builder()
                .hotelId(hotelId)
                .isLiked(isLiked)
                .hotelName(hotelName)
                .star(star)
                .reservationCount(reservationCount)
                .hotelImages(hotelImages)
                .build();
    }

    public static class Builder {
        private Long hotelId;
        private Boolean isLiked;
        private String hotelName;
        private Number star;
        private Number reservationCount;
        private List<HotelDetailImage> hotelImages;

        public Builder hotelId(final Long hotelId) {
            this.hotelId = hotelId;
            return this;
        }

         public Builder isLiked(final Boolean isLiked) {
            this.isLiked = isLiked;
            return this;
         }

         public Builder hotelName(final String hotelName) {
            this.hotelName = hotelName;
            return this;
         }

         public Builder star(final Number star) {
            this.star = star;
            return this;
         }

         public Builder reservationCount(final Number reservationCount) {
            this.reservationCount = reservationCount;
            return this;
         }

         public Builder hotelImages(final List<HotelDetailImage> hotelImages) {
            this.hotelImages = hotelImages;
            return this;
         }

         public HotelDetailRes build() {
            return new HotelDetailRes(hotelId, isLiked, hotelName, star, reservationCount, hotelImages);
         }
    }
}
