package com.sopt.agoda.common.response.message;

import org.springframework.http.HttpStatus;

public enum SuccessMessage implements ApiMessage{
    /**
     * 200 OK
     */
    OK(HttpStatus.OK,20000, "요청이 성공했습니다."),
    OK_HOTEL_LIKE(HttpStatus.OK, 20001, "호텔 좋아요에 성공했습니다."),
    OK_HOTEL_UNLIKE(HttpStatus.OK, 20002, "호텔 좋아요 취소에 성공했습니다"),

    /**
     * 201 Created
     */
    CREATED(HttpStatus.CREATED,200100, "요청이 성공했습니다.");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    private SuccessMessage(final HttpStatus httpStatus, final int code, final  String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
