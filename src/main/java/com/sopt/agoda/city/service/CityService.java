package com.sopt.agoda.city.service;

import com.sopt.agoda.city.controller.dto.res.PopularCitiesRes;
import com.sopt.agoda.city.domain.City;
import com.sopt.agoda.city.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public PopularCitiesRes getPopularCities() {
        final List<City> foundCities = cityRepository.findAll();
        final List<PopularCitiesRes.CitiesInfo> citiesInfo = foundCities.stream().map(
                city -> PopularCitiesRes.CitiesInfo.of(city.getId(), city.getName(), city.getHotelCount(), city.getImageUrl())
        ).toList();
        return PopularCitiesRes.of(citiesInfo);
    }
}
