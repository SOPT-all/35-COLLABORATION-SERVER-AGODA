package com.sopt.agoda.common.util;

import java.util.List;

public class Validator {
    public static boolean isEmptyList(List<?> list) {
        return list == null || list.isEmpty();
    }
}
