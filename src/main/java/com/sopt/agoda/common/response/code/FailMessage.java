package com.sopt.agoda.common.response.code;

import org.springframework.http.HttpStatus;

public enum FailMessage {
    /**
     * 400 Bad Request
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    INVALID_REQUEST_PARAMETER_VALUE(HttpStatus.BAD_REQUEST, "유효하지 않은 요청 파라미터 값입니다."),
    INVALID_REQUEST_JSON(HttpStatus.BAD_REQUEST, "잘못된 JSON 형식입니다."),

    /**
     * 401 Unauthorized
     */
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "리소스 접근 인증 권한이 없습니다."),

    /**
     * 403 Forbidden
     */
    FORBIDDEN(HttpStatus.FORBIDDEN, "리소스 접근 인가 권한이 없습니다."),

    /**
     * 404 Not Found
     */
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "대상을 찾을 수 없습니다."),

    /**
     * 405 Method Not Allowed
     */
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "잘못된 HTTP method 요청입니다."),

    /**
     * 409 Conflict
     */
    CONFLICT(HttpStatus.CONFLICT, "이미 존재하는 리소스입니다."),
    INTEGRITY_CONFLICT(HttpStatus.CONFLICT, "데이터 무결성 위반입니다."),

    /**
     * 500 Internal Server Error
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류입니다.");

    private final HttpStatus httpStatus;
    private final String message;

    private FailMessage(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
