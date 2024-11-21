package com.sopt.agoda.hotel.controller;

import com.sopt.agoda.common.response.ApiResponseUtil;
import com.sopt.agoda.common.response.BaseResponse;
import com.sopt.agoda.common.response.message.SuccessMessage;
import com.sopt.agoda.hotel.controller.dto.res.HotelListRes;
import com.sopt.agoda.hotel.enums.SaleType;
import com.sopt.agoda.hotel.service.HotelService;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) { this.hotelService = hotelService; }

    @GetMapping()
    public ResponseEntity<BaseResponse<?>> getHotelList(
            @RequestParam(value="saleType", required = true) final SaleType saleType,
            @RequestParam(value="cityId", required = true) @Min(1) final Long cityId
            ) {
        final HotelListRes hotels = hotelService.getHotelList(saleType, cityId);
        return ApiResponseUtil.success(SuccessMessage.OK, hotels);
    }
}
