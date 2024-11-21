package com.sopt.agoda.country.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "countries")
@JsonPropertyOrder({"countryId", "countryName", "hotelCount", "countryImage"})
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    @JsonProperty("countryId")
    private Long id;

    @Column(name = "country_name")
    @NotNull(message = "나라 이름이 null이 될 수 없습니다.")
    @JsonProperty("countryName")
    private String name;

    @Column(name = "hotel_count")
    @NotNull(message = "호텔 개수가 null이 될 수 없습니다.")
    @Min(value = 0, message = "최소 호텔 개수는 0개입니다")
    private int hotelCount;

    @Column(name = "country_image_url")
    @NotNull(message = "나라 사진이 null이 될 수 없습니다.")
    @JsonProperty("countryImage")
    private String imageUrl;

    protected Country() {}

    private Country(final String name, final int hotelCount, final String imageUrl) {
        this.name = name;
        this.hotelCount = hotelCount;
        this.imageUrl = imageUrl;
    }

    public static Country create(final String name, final int hotelCount, final String imageUrl) {
        return new Builder()
                .name(name)
                .hotelCount(hotelCount)
                .imageUrl(imageUrl)
                .build();
    }

    //빌더 클래스
    public static class Builder {
        private String name;
        private int hotelCount;
        private String imageUrl;

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder hotelCount(final int hotelCount) {
            this.hotelCount = hotelCount;
            return this;
        }

        public Builder imageUrl(final String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Country build() {
            return new Country(name, hotelCount, imageUrl);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHotelCount() {
        return hotelCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
