package com.sopt.agoda.common.converter;

import com.sopt.agoda.hotel.enums.SaleType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

public class SaleTypeConverter implements Converter<String, SaleType> {

    @Override
    public SaleType convert(@NonNull final String saleType) {
        return SaleType.create(saleType.toUpperCase());
    }
}
