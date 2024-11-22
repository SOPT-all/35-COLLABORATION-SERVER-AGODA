package com.sopt.agoda.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sopt.agoda.common.response.message.FailMessage;
import com.sopt.agoda.common.response.message.SuccessMessage;
import org.springframework.http.HttpStatus;


public class BaseResponse<T> {
    private final int code;
    private final String message;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private final T data;

    private BaseResponse(final int status, final String message, final T data) {
        this.code = status;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse<?> of(SuccessMessage successMessage) {
        return builder()
                .status(successMessage.getCode())
                .message(successMessage.getMessage())
                .build();
    }

    public static <T> BaseResponse<?> of(SuccessMessage successMessage, T data) {
        return builder()
                .status(successMessage.getCode())
                .message(successMessage.getMessage())
                .data(data)
                .build();
    }

    public static BaseResponse<?> of(FailMessage failMessage) {
        return builder()
                .status(failMessage.getCode())
                .message(failMessage.getMessage())
                .build();
    }

    public static BaseResponse<?> of(final int code, final String message) {
        return builder()
                .status(code)
                .message(message)
                .build();
    }

    public static class Builder<T> {
        private int code;
        private String message;
        private T data;

        public Builder<T> status(final int status) {
            this.code = status;
            return this;
        }

        public Builder<T> message(final String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(final T data) {
            this.data = data;
            return this;
        }

        public BaseResponse<T> build() {
            return new BaseResponse<>(code, message, data);
        }
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
