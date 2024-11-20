package com.sopt.agoda.country.controller.dto.res;

import com.sopt.agoda.country.domain.Country;

import java.util.List;

public record BestCountryRes(
        List<Country> bestCountries
) {

    public static BestCountryRes of(final List<Country> bestCountryInfo) {
        return new BestCountryRes(bestCountryInfo);
    }
}
