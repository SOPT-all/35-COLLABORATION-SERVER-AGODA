package com.sopt.agoda.hotel.enums;

import com.sopt.agoda.common.exception.AgodaException;
import com.sopt.agoda.common.response.message.FailMessage;

import java.util.Arrays;

public enum SaleType {
    DEFAULT("default"),
    TIME_LIMIT("timeLimit");

    private final String value;

    SaleType(String value) {
        this.value = value;
    }

    public static SaleType create(final String requestSaleType) {
        return Arrays.stream(SaleType.values())
                .filter(saleType -> saleType.value.equalsIgnoreCase(requestSaleType))
                .findFirst()
                .orElseThrow(() -> new AgodaException(FailMessage.BAD_REQUEST_SALETYPE_VALUE));
    }
}
