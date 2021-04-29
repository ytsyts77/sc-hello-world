package com.samsungcard.helloworld.global.utils;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {
    private final MessageSource source;

    public MessageUtil(MessageSource source) {
        this.source = source;
    }

    public String getMessage(String code) {
        return source.getMessage(code, null, Locale.getDefault());
    }

    public String getMessage(String code, String[] args) {
        return source.getMessage(code, args, Locale.getDefault());
    }
}
