package com.sopt.agoda.country.controller.dto.res;

import java.util.List;

public record BestCountryRes(
        List<BestCountryInfo> bestCountries
) {

    public static BestCountryRes of(final List<BestCountryInfo> bestCountryInfo) {
        return new BestCountryRes(bestCountryInfo);
    }

    public record BestCountryInfo(
            Long countryId,
            String countryName,
            int hotelCount,
            String countryImage
    ) {

        public static BestCountryInfo of(final Long countryId, final String countryName, final int hotelCount, final String countryImage) {
            return new BestCountryInfo.Builder()
                    .countryId(countryId)
                    .countryName(countryName)
                    .hotelCount(hotelCount)
                    .countryImage(countryImage)
                    .build();
        }

        public static class Builder {
            private Long countryId;
            private String countryName;
            private int hotelCount;
            private String countryImage;

            public Builder countryId(Long countryId) {
                this.countryId = countryId;
                return this;
            }

            public Builder countryName(String countryName) {
                this.countryName = countryName;
                return this;
            }

            public Builder hotelCount(int hotelCount) {
                this.hotelCount = hotelCount;
                return this;
            }

            public Builder countryImage(String countryImage) {
                this.countryImage = countryImage;
                return this;
            }

            public BestCountryInfo build() {
                return new BestCountryInfo(countryId, countryName, hotelCount, countryImage);
            }
        }
    }
}
