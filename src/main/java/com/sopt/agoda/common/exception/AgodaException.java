package com.sopt.agoda.common.exception;

import com.sopt.agoda.common.response.code.FailMessage;

public class AgodaException extends RuntimeException{
    private final FailMessage failMessage;

    public AgodaException(FailMessage failMessage) {
        super(failMessage.getMessage());
        this.failMessage = failMessage;
    }

    public FailMessage getFailMessage() {
        return failMessage;
    }
}
