package com.sopt.agoda.hotel.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;

    @Column(name = "hotel_name")
    @NotBlank(message = "호텔 이름이 null이면 안됩니다.")
    private String hotelName;

    @Column(name = "star")
    @NotNull(message = "별이 null이면 안됩니다.")
    private int star;

    @Column(name = "hotel_district")
    @NotBlank(message = "호텔 지역이 null이면 안됩니다.")
    private String hotelDistrict;

    @Column(name = "rating")
    @NotNull(message = "평점이 null이면 안됩니다.")
    private double rating;

    @Column(name = "review_count")
    @NotNull(message = "리뷰 개수가 null이면 안됩니다.")
    private int reviewCount;

    @Column(name = "original_price")
    @NotNull(message = "원가격이 null이면 안됩니다.")
    private int originalPrice;

    @Column(name = "discount_price")
    private int discountPrice;

    @Column(name = "is_quarter_discount")
    private boolean isQuarterDiscount;

    @Column(name = "tax_price")
    @NotNull(message = "세금가격이 null이면 안됩니다.")
    private int taxPrice;

    @Column(name = "is_liked")
    private boolean isLiked;

    @Column(name = "reservation_count")
    @NotNull(message = "예약 횟수가 null이면 안됩니다.")
    private int reservationCount;

    @Column(name = "is_time_sale")
    private boolean isTimeSale;

    @Column(name = "city_id")
    @NotNull(message = "도시 아이디가 null이면 안됩니다.")
    private Long cityId;

    protected Hotel() {}

    private Hotel(final Builder builder) {
        this.hotelName = builder.hotelName;
        this.star = builder.star;
        this.hotelDistrict = builder.hotelDistrict;
        this.rating = builder.rating;
        this.reviewCount = builder.reviewCount;
        this.originalPrice = builder.originalPrice;
        this.discountPrice = builder.discountPrice;
        this.isQuarterDiscount = builder.isQuarterDiscount;
        this.taxPrice = builder.taxPrice;
        this.isLiked = builder.isLiked;
        this.reservationCount = builder.reservationCount;
        this.isTimeSale = builder.isTimeSale;
        this.cityId = builder.cityId;
    }
    
    public static Hotel create(String hotelName, int star, String hotelDistrict, double rating, int reviewCount,
                               int originalPrice, int discountPrice, boolean isQuarterDiscount, int taxPrice,
                               boolean isLiked, int reservationCount, boolean isTimeSale, Long cityId) {
        return new Hotel.Builder()
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
                .reservationCount(reservationCount)
                .isTimeSale(isTimeSale)
                .cityId(cityId)
                .build();
    }

    //빌더 클래스
    public static class Builder {
        private String hotelName;
        private int star;
        private String hotelDistrict;
        private double rating;
        private int reviewCount;
        private int originalPrice;
        private int discountPrice;
        private boolean isQuarterDiscount;
        private int taxPrice;
        private boolean isLiked;
        private int reservationCount;
        private boolean isTimeSale;
        private Long cityId;

        public Builder hotelName(final String hotelName) {
            this.hotelName = hotelName;
            return this;
        }

        public Builder star(int star) {
            this.star = star;
            return this;
        }

        public Builder hotelDistrict(final String hotelDistrict) {
            this.hotelDistrict = hotelDistrict;
            return this;
        }

        public Builder rating(final double rating) {
            this.rating = rating;
            return this;
        }

        public Builder reviewCount(final int reviewCount) {
            this.reviewCount = reviewCount;
            return this;
        }

        public Builder originalPrice(final int originalPrice) {
            this.originalPrice = originalPrice;
            return this;
        }

        public Builder discountPrice(final int discountPrice) {
            this.discountPrice = discountPrice;
            return this;
        }

        public Builder isQuarterDiscount(final boolean isQuarterDiscount) {
            this.isQuarterDiscount = isQuarterDiscount;
            return this;
        }

        public Builder taxPrice(final int taxPrice) {
            this.taxPrice = taxPrice;
            return this;
        }

        public Builder isLiked(final boolean isLiked) {
            this.isLiked = isLiked;
            return this;
        }

        public Builder reservationCount(final int reservationCount) {
            this.reservationCount = reservationCount;
            return this;
        }

        public Builder isTimeSale(final boolean isTimeSale) {
            this.isTimeSale = isTimeSale;
            return this;
        }

        public Builder cityId(final Long cityId) {
            this.cityId = cityId;
            return this;
        }

        public Hotel build() {
            return new Hotel(this);
        }
    }
}
