package com.sopt.agoda.hotel.enums;

import com.sopt.agoda.common.exception.AgodaException;
import com.sopt.agoda.common.response.message.FailMessage;

public enum SaleType {
    DEFAULT,
    TIME_LIMIT;

    public static SaleType create(String requestCategory) {
        for (SaleType value : SaleType.values()) {
            if (value.toString().equals(requestCategory)) {
                return value;
            }
        }
        throw new AgodaException(FailMessage.BAD_REQUEST_SALETYPE_VALUE);
    }
}
