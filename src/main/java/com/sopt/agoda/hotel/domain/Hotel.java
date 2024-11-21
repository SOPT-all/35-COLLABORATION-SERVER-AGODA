package com.sopt.agoda.hotel.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id", nullable = false)
    private Long id;

    @Column(name = "hotel_name", nullable = false)
    @NotBlank(message = "호텔 이름이 null이면 안됩니다.")
    private String hotelName;

    @Column(name = "star", nullable = false)
    @NotNull(message = "별이 null이면 안됩니다.")
    @Min(value = 0, message = "최소 별은 0개입니다")
    private int star;

    @Column(name = "hotel_district", nullable = false)
    @NotBlank(message = "호텔 지역이 null이면 안됩니다.")
    private String hotelDistrict;

    @Column(name = "rating", nullable = false)
    @NotNull(message = "평점이 null이면 안됩니다.")
    @Min(value = 0, message = "최소 평점은 0개입니다")
    private double rating;

    @Column(name = "review_count", nullable = false)
    @NotNull(message = "리뷰 개수가 null이면 안됩니다.")
    @Min(value = 0, message = "최소 리뷰 개수는 0개입니다")
    private int reviewCount;

    @Column(name = "original_price", nullable = false)
    @NotNull(message = "원가격이 null이면 안됩니다.")
    @Min(value = 0, message = "최소 원가격은 0개입니다")
    private int originalPrice;

    @Column(name = "discount_price")
    @NotNull(message = "할인 가격이 null이면 안됩니다.")
    @Min(value = 0, message = "최소 할인 가격은 0개입니다")
    private int discountPrice;

    @Column(name = "is_quarter_discount", nullable = false)
    @NotNull(message = "25프로 할인 여부가 null이면 안됩니다.")
    private boolean isQuarterDiscount;

    @Column(name = "tax_price", nullable = false)
    @NotNull(message = "세금가격이 null이면 안됩니다.")
    @Min(value = 0, message = "최소 세금 가격은 0개입니다")
    private int taxPrice;

    @Column(name = "is_liked", nullable = false)
    @NotNull(message = "호텔 좋아요 여부가 null이면 안됩니다.")
    private boolean isLiked;

    @Column(name = "reservation_count", nullable = false)
    @NotNull(message = "예약 횟수가 null이면 안됩니다.")
    @Min(value = 0, message = "최소 예약 횟수는 0개입니다")
    private int reservationCount;

    @Column(name = "is_time_sale", nullable = false)
    @NotNull(message = "시간 할인 여부가 null이면 안됩니다.")
    private boolean isTimeSale;

    @Column(name = "city_id", nullable = false)
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

    public static Hotel create(final String hotelName, final int star, final String hotelDistrict, final double rating,
                               final int reviewCount, final int originalPrice, final int discountPrice,
                               final boolean isQuarterDiscount, final int taxPrice, final boolean isLiked,
                               final int reservationCount, final boolean isTimeSale, final Long cityId) {
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

    // 빌더 클래스
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

        public Builder star(final int star) {
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

    public Long getId() {
        return id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getStar() {
        return star;
    }

    public String getHotelDistrict() {
        return hotelDistrict;
    }

    public double getRating() {
        return rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public boolean isQuarterDiscount() {
        return isQuarterDiscount;
    }

    public int getTaxPrice() {
        return taxPrice;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public boolean isTimeSale() {
        return isTimeSale;
    }

    public void setLiked(boolean liked) {
        this.isLiked = liked;
    }
}
