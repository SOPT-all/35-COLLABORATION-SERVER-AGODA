package com.sopt.agoda.common.response.message;

import org.springframework.http.HttpStatus;

public enum SuccessMessage {
    /**
     * 200 OK
     */
    OK(HttpStatus.OK, "s2000", "요청이 성공했습니다."),

    /**
     * 201 Created
     */
    CREATED(HttpStatus.CREATED, "s2010", "요청이 성공했습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    private SuccessMessage(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
