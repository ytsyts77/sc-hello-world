package com.samsungcard.helloworld.global.error.exception;

import com.samsungcard.helloworld.global.common.message.UserMessage;

public class InvalidValueException extends BusinessException {
    public InvalidValueException(UserMessage userMessage) {
        super(userMessage);
    }

    public InvalidValueException(UserMessage userMessage, Object... o) {
        super(userMessage, o);
    }
}
