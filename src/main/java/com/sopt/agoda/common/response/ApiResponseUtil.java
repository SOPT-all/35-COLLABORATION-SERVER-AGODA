package com.sopt.agoda.common.response;

import com.sopt.agoda.common.response.code.FailMessage;
import com.sopt.agoda.common.response.code.SuccessMessage;
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
}
