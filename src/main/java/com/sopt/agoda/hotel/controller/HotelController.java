package com.sopt.agoda.hotel.controller;

import com.sopt.agoda.common.response.ApiResponseUtil;
import com.sopt.agoda.common.response.BaseResponse;
import com.sopt.agoda.common.response.message.SuccessMessage;
import com.sopt.agoda.hotel.controller.dto.res.HotelDetailRes;
import com.sopt.agoda.hotel.controller.dto.res.HotelListRes;
import com.sopt.agoda.hotel.enums.SaleType;
import com.sopt.agoda.hotel.service.HotelService;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{hotelId}/details")
    public ResponseEntity<BaseResponse<?>> getHotelDetail(@PathVariable @Min(1) final Long hotelId) {
        final HotelDetailRes hotelDetail = hotelService.getHotelDetail(hotelId);
        return ApiResponseUtil.success(SuccessMessage.OK, hotelDetail);
    }

    @PatchMapping("/likes/{hotelId}")
    public ResponseEntity<BaseResponse<?>> patchHotelLike(
            @Min(1) @PathVariable final Long hotelId,
            @RequestParam(value = "isLiked", required = true) final boolean isLiked
    ) {
        hotelService.patchHotelLike(hotelId, isLiked);
        return ApiResponseUtil.success(SuccessMessage.OK);
    }

}
