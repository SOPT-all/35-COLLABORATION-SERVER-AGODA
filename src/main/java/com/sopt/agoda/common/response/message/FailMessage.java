package com.sopt.agoda.common.response.message;

import org.springframework.http.HttpStatus;

public enum FailMessage implements ApiMessage{
    /**
     * 400 Bad Request
     */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    BAD_REQUEST_PARAMETER_VALUE(HttpStatus.BAD_REQUEST, "유효하지 않은 요청 파라미터 값입니다."),
    BAD_REQUEST_JSON(HttpStatus.BAD_REQUEST, "잘못된 JSON 형식입니다."),
    BAD_REQUEST_HTTP_METHOD(HttpStatus.METHOD_NOT_ALLOWED, "잘못된 http method입니다."),
    BAD_REQUEST_SALETYPE_PARAMETER_VALUE(HttpStatus.BAD_REQUEST, "잘못된 인자값 : SaleType"),

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
    NOT_FOUND_ENTITY(HttpStatus.NOT_FOUND, "대상을 찾을 수 없습니다."),
    NOT_FOUND_API(HttpStatus.NOT_FOUND, "잘못된 API입니다.."),
    NOT_FOUND_POPULAR_CITIES(HttpStatus.NOT_FOUND, "인기 도시를 찾을 수 없습니다."),
    NOT_FOUND_BEST_COUNTRY(HttpStatus.NOT_FOUND, "베스트 여행지를 찾을 수 없습니다."),
    NOT_FOUND_SEARCH_CITIES(HttpStatus.NOT_FOUND, "검색 도시 리스트를 찾을 수 없습니다."),


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
