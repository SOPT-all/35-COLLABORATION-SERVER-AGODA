package com.sopt.agoda.hotel.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "hotel_images")
public class HotelImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_image_id")
    private Long id;

    @Column(name = "hotel_id", nullable = false)
    @NotNull(message = "호텔 ID가 null이면 안됩니다.")
    private Long hotelId;

    @Column(name = "hotel_image_url", nullable = false)
    @NotBlank(message = "호텔 이미지 URL이 null이면 안됩니다.")
    private String hotelImageUrl;

    protected HotelImage() {
    }

    private HotelImage(final Builder builder) {
        this.hotelId = builder.hotelId;
        this.hotelImageUrl = builder.hotelImageUrl;
    }

    public static HotelImage create(final Long hotelId, final String hotelImageUrl) {
        return new Builder()
                .hotelId(hotelId)
                .hotelImageUrl(hotelImageUrl)
                .build();
    }

    //빌더 클래스
    public static class Builder {
        private Long hotelId;
        private String hotelImageUrl;

        public Builder hotelId(final Long hotelId) {
            this.hotelId = hotelId;
            return this;
        }

        public Builder hotelImageUrl(final String hotelImageUrl) {
            this.hotelImageUrl = hotelImageUrl;
            return this;
        }

        public HotelImage build() {
            return new HotelImage(this);
        }
    }
}

