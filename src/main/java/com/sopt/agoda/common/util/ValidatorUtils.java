package com.sopt.agoda.common.util;

import java.util.List;

public class ValidatorUtils {
    public static boolean isEmptyList(List<?> list) {
        return list == null || list.isEmpty();
    }
}
