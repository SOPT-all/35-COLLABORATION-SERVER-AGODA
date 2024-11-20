package com.sopt.agoda.country.service;

import com.sopt.agoda.country.controller.dto.res.BestCountryRes;
import com.sopt.agoda.country.domain.Country;
import com.sopt.agoda.country.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public BestCountryRes getBestCountries() {
        List<Country> foundCountries = countryRepository.findAll();
        return BestCountryRes.of(foundCountries);
    }
}
