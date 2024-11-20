package com.sopt.agoda.city.controller.dto.res;

import java.util.List;

public record CitiesRes(
        List<SearchCityInfo> cities
) {
    public static CitiesRes of(final List<SearchCityInfo> cityInfos) {
        return new CitiesRes(cityInfos);
    }

    public record SearchCityInfo(
            Long cityId,
            String cityName,
            String countryName
    ) {

        public static SearchCityInfo of(final Long cityId, final String cityName, final String countryName) {
            return new Builder()
                    .cityId(cityId)
                    .cityName(cityName)
                    .countryName(countryName)
                    .build();
        }

        private static class Builder {
            private Long cityId;
            private String cityName;
            private String countryName;

            private Builder cityId(final Long cityId) {
                this.cityId = cityId;
                return this;
            }

            private Builder cityName(final String cityName) {
                this.cityName = cityName;
                return this;
            }

            private Builder countryName(final String countryName) {
                this.countryName = countryName;
                return this;
            }

            private SearchCityInfo build() {
                return new SearchCityInfo(cityId, cityName, countryName);
            }
        }
    }
}
