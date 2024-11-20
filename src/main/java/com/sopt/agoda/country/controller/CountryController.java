package com.sopt.agoda.country.controller;

import com.sopt.agoda.common.response.ApiResponseUtil;
import com.sopt.agoda.common.response.BaseResponse;
import com.sopt.agoda.common.response.message.SuccessMessage;
import com.sopt.agoda.country.controller.dto.res.BestCountryRes;
import com.sopt.agoda.country.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/best-locations")
    public ResponseEntity<BaseResponse<?>> getBestLocations() {
        final BestCountryRes response = countryService.getBestCountries();
        return ApiResponseUtil.success(SuccessMessage.OK, response);
    }
}