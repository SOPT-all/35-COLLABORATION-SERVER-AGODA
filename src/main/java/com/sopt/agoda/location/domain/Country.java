package com.sopt.agoda.location.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country_name")
    @NotNull(message = "나라 이름이 null이 될 수 없습니다.")
    private String name;

    @Column(name = "country_image_url")
    @NotNull(message = "나라 사진이 null이 될 수 없습니다.")
    private String imageUrl;

    protected Country() {}

    private Country(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public static Country create(final String name, final String imageUrl) {
        return new Country.Builder()
                .name(name)
                .imageUrl(imageUrl)
                .build();
    }

    //빌더 클래스
    public static class Builder {
        private String name;
        private String imageUrl;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Country build() {
            return new Country(name, imageUrl);
        }
    }
}
