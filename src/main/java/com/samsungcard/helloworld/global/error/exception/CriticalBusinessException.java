package com.samsungcard.helloworld.global.error.exception;

import com.samsungcard.helloworld.global.common.message.UserMessage;

public class CriticalBusinessException extends BusinessException {
    public CriticalBusinessException(UserMessage userMessage) {
        super(userMessage);
    }

    public CriticalBusinessException(UserMessage userMessage, Object... o) {
        super(userMessage, o);
    }
}
