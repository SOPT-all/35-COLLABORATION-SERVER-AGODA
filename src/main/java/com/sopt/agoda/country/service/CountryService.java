package com.sopt.agoda.country.service;

import com.sopt.agoda.common.exception.AgodaException;
import com.sopt.agoda.common.response.message.FailMessage;
import com.sopt.agoda.common.util.ValidatorUtils;
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
        if (ValidatorUtils.isEmptyList(foundCountries)) {
            throw new AgodaException(FailMessage.NOT_FOUND_BEST_COUNTRY);
        }
        return BestCountryRes.of(foundCountries);
    }
}
