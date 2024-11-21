package com.sopt.agoda.common.config;
import org.springframework.format.FormatterRegistry;

import com.sopt.agoda.common.converter.SaleTypeConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new SaleTypeConverter());
    }
}