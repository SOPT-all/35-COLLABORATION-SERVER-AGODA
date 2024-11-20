package com.sopt.agoda.city.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    @Column(name = "city_name")
    @NotNull(message = "도시 이름이 null이 될 수 없습니다.")
    private String name;

    @Column(name = "hotel_count")
    @NotNull(message = "호텔 개수가 null이 될 수 없습니다.")
    @Size(min = 0, message = "호텔 최소 개수는 0개입니다.")
    private int hotelCount;

    @Column(name = "city_image_url")
    @NotNull(message = "도시 이미지가 null이 될 수 없습니다.")
    private String imageUrl;

    @Column(name = "country_id")
    @NotNull(message = "나라 아이디가 null이 될 수 없습니다.")
    private Long countryId;

    protected City() {}

    private City(String name, String imageUrl, Long countryId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.countryId = countryId;
    }

    public static City create(final String name, final String imageUrl, final Long countryId) {
        return new City.Builder()
                .name(name)
                .imageUrl(imageUrl)
                .countryId(countryId)
                .build();
    }

    //빌더 클래스
    public static class Builder {
        private String name;
        private String imageUrl;
        private Long countryId;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder countryId(Long countryId) {
            this.countryId = countryId;
            return this;
        }

        public City build() {
            return new City(name, imageUrl, countryId);
        }
    }
}
