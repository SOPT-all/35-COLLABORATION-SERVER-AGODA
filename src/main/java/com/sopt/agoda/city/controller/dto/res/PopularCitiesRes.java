package com.sopt.agoda.city.controller.dto.res;

import com.sopt.agoda.city.domain.City;

import java.util.List;

public record PopularCitiesRes(
        List<CitiesInfo> popularCities
) {
    public static PopularCitiesRes of(final List<CitiesInfo> popularCities) {
        return new PopularCitiesRes(popularCities);
    }

    public record CitiesInfo(
            Long cityId,
            String cityName,
            int hotelCount,
            String cityImage
    ) {

        public static CitiesInfo of(final Long cityId, final String cityName, final int hotelCount, final String cityImage) {
            return new CitiesInfo.Builder()
                    .cityId(cityId)
                    .cityName(cityName)
                    .cityImage(cityImage)
                    .build();
        }

        // 빌더 패턴을 위한 Builder 클래스
        public static class Builder {
            private Long cityId;
            private String cityName;
            private int hotelCount;
            private String cityImage;

            public Builder cityId(final Long cityId) {
                this.cityId = cityId;
                return this;
            }

            public Builder cityName(final String cityName) {
                this.cityName = cityName;
                return this;
            }

            public Builder hotelCount(final int hotelCount) {
                this.hotelCount = hotelCount;
                return this;
            }

            public Builder cityImage(final String cityImage) {
                this.cityImage = cityImage;
                return this;
            }

            public CitiesInfo build() {
                return new CitiesInfo(cityId, cityName, hotelCount, cityImage);
            }
        }
    }
}