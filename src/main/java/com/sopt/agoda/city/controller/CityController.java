package com.sopt.agoda.city.controller;

import com.sopt.agoda.city.controller.dto.res.CitiesRes;
import com.sopt.agoda.city.controller.dto.res.PopularCitiesRes;
import com.sopt.agoda.city.service.CityService;
import com.sopt.agoda.common.response.ApiResponseUtil;
import com.sopt.agoda.common.response.BaseResponse;
import com.sopt.agoda.common.response.message.SuccessMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/popular-cities")
    public ResponseEntity<BaseResponse<?>> getPopularCities() {
        final PopularCitiesRes response = cityService.getPopularCities();
        return ApiResponseUtil.success(SuccessMessage.OK, response);
    }

    @GetMapping("/cities")
    public ResponseEntity<BaseResponse<?>> getCities() {
        final CitiesRes response = cityService.getCities();
        return ApiResponseUtil.success(SuccessMessage.OK, response);
    }
}
