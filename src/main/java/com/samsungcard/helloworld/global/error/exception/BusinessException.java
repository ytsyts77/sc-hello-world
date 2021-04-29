package com.samsungcard.helloworld.global.error.exception;

import com.samsungcard.helloworld.global.common.message.UserMessage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BusinessException extends RuntimeException {
    private final UserMessage userMessage;

    public BusinessException(UserMessage userMessage) {
        super(userMessage.get());
        this.userMessage = userMessage;
    }

    public BusinessException(UserMessage userMessage, Object... o) {
        super(userMessage.get(o));
        this.userMessage = userMessage;
    }

    public UserMessage getUserMessage() {
        return userMessage;
    }
}
