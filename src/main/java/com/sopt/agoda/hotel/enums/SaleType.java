package com.sopt.agoda.hotel.enums;

import com.sopt.agoda.common.exception.AgodaException;
import com.sopt.agoda.common.response.message.FailMessage;

public enum SaleType {
    DEFAULT("default"),
    TIME_LIMIT("timeLimit");

    private final String value;

    SaleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static SaleType fromString(String value) {
        for (SaleType saleType : values()) {
            if (saleType.getValue().equalsIgnoreCase(value)) {
                return saleType;
            }
        }
        throw new AgodaException(FailMessage.BAD_REQUEST_SALETYPE_PARAMETER_VALUE);
    }
}
