package com.sopt.agoda.city.service;

import com.sopt.agoda.city.controller.dto.res.CitiesRes;
import com.sopt.agoda.city.controller.dto.res.PopularCitiesRes;
import com.sopt.agoda.city.domain.City;
import com.sopt.agoda.city.repository.CityRepository;
import com.sopt.agoda.common.exception.AgodaException;
import com.sopt.agoda.common.response.message.FailMessage;
import com.sopt.agoda.common.util.ValidatorUtils;
import com.sopt.agoda.country.domain.Country;
import com.sopt.agoda.country.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    public CityService(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public PopularCitiesRes getPopularCities() {
        final List<City> foundCities = cityRepository.findAll();
        //빈 값인지 검증
        if (checkIfEmptyCityList(foundCities)) {
            throw new AgodaException(FailMessage.NOT_FOUND_POPULAR_CITIES);
        }

        final List<PopularCitiesRes.CitiesInfo> citiesInfo = foundCities.stream().map(
                city -> PopularCitiesRes.CitiesInfo.of(city.getId(), city.getName(), city.getHotelCount(), city.getImageUrl())
        ).toList();
        return PopularCitiesRes.of(citiesInfo);
    }

    public CitiesRes getCities() {
        final List<City> foundCities = cityRepository.findAll();
        //빈 값인지 검증
        if (checkIfEmptyCityList(foundCities)) {
            throw new AgodaException(FailMessage.NOT_FOUND_SEARCH_CITIES);
        }

        final List<CitiesRes.SearchCityInfo> searchCityInfos = foundCities.stream().map(
                city -> {
                    final Country foundCountry = countryRepository.findById(city.getCountryId()).orElseThrow(
                            () -> new AgodaException(FailMessage.NOT_FOUND_SEARCH_CITIES));
                    return CitiesRes.SearchCityInfo.of(city.getId(), city.getName(), foundCountry.getName());
                }
        ).toList();
        return CitiesRes.of(searchCityInfos);
    }

    private boolean checkIfEmptyCityList(final List<City> foundCities) {
        return ValidatorUtils.isEmptyList(foundCities);
    }
}
