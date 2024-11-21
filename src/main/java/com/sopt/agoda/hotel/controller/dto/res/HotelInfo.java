package com.sopt.agoda.hotel.controller.dto.res;

import com.sopt.agoda.hotel.domain.Hotel;

public record HotelInfo(
        Long hotelId,
        String hotelName,
        Number star,
        String hotelDistrict,
        Double rating,
        Number reviewCount,
        Number originalPrice,
        Number discountPrice,
        Boolean isQuarterDiscount,
        Number taxPrice,
        Boolean isLiked,
        String hotelImage,
        Boolean isTimeSale
) {
    public static HotelInfo of (final Long hotelId, final String hotelName, final Number star, final String hotelDistrict, final Double rating, final Number reviewCount, final Number originalPrice, final Number discountPrice, final Boolean isQuarterDiscount, final Number taxPrice, final Boolean isLiked, final String hotelImage, final Boolean isTimeSale) {
        return new Builder()
                .hotelId(hotelId)
                .hotelName(hotelName)
                .star(star)
                .hotelDistrict(hotelDistrict)
                .rating(rating)
                .reviewCount(reviewCount)
                .originalPrice(originalPrice)
                .discountPrice(discountPrice)
                .isQuarterDiscount(isQuarterDiscount)
                .taxPrice(taxPrice)
                .isLiked(isLiked)
                .hotelImage(hotelImage)
                .isTimeSale(isTimeSale)
                .build();
    }

    public static HotelInfo of (final Hotel hotel, final String hotelImageUrl) {
        return new HotelInfo (
                hotel.getId(),
                hotel.getHotelName(),
                hotel.getStar(),
                hotel.getHotelDistrict(),
                hotel.getRating(),
                hotel.getReviewCount(),
                hotel.getOriginalPrice(),
                hotel.getDiscountPrice(),
                hotel.isQuarterDiscount(),
                hotel.getTaxPrice(),
                hotel.isLiked(),
                hotelImageUrl,
                hotel.isTimeSale()
        );
    }


    public static class Builder {
        private Long hotelId;
        private String hotelName;
        private Number star;
        private String hotelDistrict;
        private Double rating;
        private Number reviewCount;
        private Number originalPrice;
        private Number discountPrice;
        private Boolean isQuarterDiscount;
        private Number taxPrice;
        private Boolean isLiked;
        private String hotelImage;
        private Boolean isTimeSale;

        public Builder hotelId(final Long hotelId) {
            this.hotelId = hotelId;
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

        public Builder hotelDistrict(final String hotelDistrict) {
            this.hotelDistrict = hotelDistrict;
            return this;
        }

        public Builder rating(final Double rating) {
            this.rating = rating;
            return this;
        }

        public Builder reviewCount(final Number reviewCount) {
            this.reviewCount = reviewCount;
            return this;
        }

        public Builder originalPrice(final Number originalPrice) {
            this.originalPrice = originalPrice;
            return this;
        }

        public Builder discountPrice(final Number discountPrice) {
            this.discountPrice = discountPrice;
            return this;
        }

        public Builder isQuarterDiscount(final Boolean isQuarterDiscount) {
            this.isQuarterDiscount = isQuarterDiscount;
            return this;
        }

        public Builder taxPrice(final Number taxPrice) {
            this.taxPrice = taxPrice;
            return this;
        }

        public Builder isLiked(final Boolean isLiked) {
            this.isLiked = isLiked;
            return this;
        }

        public Builder hotelImage(final String hotelImage) {
            this.hotelImage = hotelImage;
            return this;
        }

        public Builder isTimeSale(final Boolean isTimeSale) {
            this.isTimeSale = isTimeSale;
            return this;
        }

        public HotelInfo build() {
            return new HotelInfo(hotelId, hotelName, star, hotelDistrict, rating, reviewCount, originalPrice, discountPrice, isQuarterDiscount, taxPrice, isLiked, hotelImage, isTimeSale);
        }
    }
}