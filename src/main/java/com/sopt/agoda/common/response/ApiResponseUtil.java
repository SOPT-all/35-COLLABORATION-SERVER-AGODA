package com.sopt.agoda.common.response;

import com.sopt.agoda.common.response.message.FailMessage;
import com.sopt.agoda.common.response.message.SuccessMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public interface ApiResponseUtil {
    static ResponseEntity<BaseResponse<?>> success(final SuccessMessage successMessage) {
        return ResponseEntity.status(successMessage.getHttpStatus())
                .body(BaseResponse.of(successMessage));
    }

    static <T> ResponseEntity<BaseResponse<?>> success(final SuccessMessage successMessage, final T data) {
        return ResponseEntity.status(successMessage.getHttpStatus())
                .body(BaseResponse.of(successMessage, data));
    }

    static ResponseEntity<BaseResponse<?>> failure(final FailMessage failMessage) {
        return ResponseEntity.status(failMessage.getHttpStatus())
                .body(BaseResponse.of(failMessage));
    }

    static ResponseEntity<BaseResponse<?>> failure(final HttpStatus httpStatus, final String message) {
        return ResponseEntity
                .status(httpStatus)
                .body(BaseResponse.of(httpStatus, message));
    }
}
