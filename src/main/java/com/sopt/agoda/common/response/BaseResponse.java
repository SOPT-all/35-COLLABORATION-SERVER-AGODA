package com.sopt.agoda.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sopt.agoda.common.response.code.FailMessage;
import com.sopt.agoda.common.response.code.SuccessMessage;
import org.springframework.http.HttpStatus;

public class BaseResponse<T> {
    private final int status;
    private final String message;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private final T data;

    private BaseResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse<?> of(SuccessMessage successMessage) {
        return builder()
                .status(successMessage.getHttpStatus().value())
                .message(successMessage.getMessage())
                .build();
    }

    public static <T> BaseResponse<?> of(SuccessMessage successMessage, T data) {
        return builder()
                .status(successMessage.getHttpStatus().value())
                .message(successMessage.getMessage())
                .data(data)
                .build();
    }

    public static BaseResponse<?> of(FailMessage failMessage) {
        return builder()
                .status(failMessage.getHttpStatus().value())
                .message(failMessage.getMessage())
                .build();
    }

    public static BaseResponse<?> of(HttpStatus httpStatus, String message) {
        return builder()
                .status(httpStatus.value())
                .message(message)
                .build();
    }

    public static class Builder<T> {
        private int status;
        private String message;
        private T data;

        public Builder<T> status(int status) {
            this.status = status;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public BaseResponse<T> build() {
            return new BaseResponse<>(status, message, data);
        }
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
