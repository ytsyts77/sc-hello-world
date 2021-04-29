package com.samsungcard.helloworld.global.error;

import com.samsungcard.helloworld.global.common.message.UserMessage;
import com.samsungcard.helloworld.global.error.exception.BusinessException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private String message;
    private int status;
    private List<FieldError> errors;
    private String userMessage;

    private ErrorResponse(final UserMessage userMessage, final List<FieldError> errors) {
        this.message = userMessage.get();
        this.status = userMessage.getStatus();
        this.errors = errors;
        this.userMessage = userMessage.getCode();
    }

    private ErrorResponse(final UserMessage userMessage) {
        this.message = userMessage.get();
        this.status = userMessage.getStatus();
        this.userMessage = userMessage.getCode();
        this.errors = new ArrayList<>();
    }

    private ErrorResponse(final BusinessException e) {
        UserMessage userMessage = e.getUserMessage();
        this.message = e.getMessage();
        this.status = userMessage.getStatus();
        this.userMessage = userMessage.getCode();
        this.errors = new ArrayList<>();
    }

    public static ErrorResponse of(final UserMessage userMessage, final BindingResult bindingResult) {
        return new ErrorResponse(userMessage, FieldError.of(bindingResult));
    }

    public static ErrorResponse of(final UserMessage userMessage) {
        return new ErrorResponse(userMessage);
    }

    public static ErrorResponse of(final UserMessage userMessage, final List<FieldError> errors) {
        return new ErrorResponse(userMessage, errors);
    }

    public static ErrorResponse of(final BusinessException e) {
        return new ErrorResponse(e);
    }

    public static ErrorResponse of(MethodArgumentTypeMismatchException e) {
        final String value = e.getValue() == null ? "" : e.getValue().toString();
        final List<ErrorResponse.FieldError> errors = ErrorResponse.FieldError.of(e.getName(), value, e.getErrorCode());
        return new ErrorResponse(UserMessage.INVALID_TYPE, errors);
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FieldError {
        private String field;
        private String value;
        private String reason;

        private FieldError(final String field, final String value, final String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

        public static List<FieldError> of(final String field, final String value, final String reason) {
            List<FieldError> fieldErrors = new ArrayList<>();
            fieldErrors.add(new FieldError(field, value, reason));
            return fieldErrors;
        }

        private static List<FieldError> of(final BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }
}
