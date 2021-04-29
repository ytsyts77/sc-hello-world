package com.samsungcard.helloworld.global.error.advice;

import com.samsungcard.helloworld.global.common.message.UserMessage;
import com.samsungcard.helloworld.global.error.exception.BusinessException;
import com.samsungcard.helloworld.global.error.exception.CriticalBusinessException;
import com.samsungcard.helloworld.global.error.ErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.nio.file.AccessDeniedException;

//@ControllerAdvice(annotations = Controller.class)
//@Order(2)
public class ControllerExceptionHandler {
    /**
     * javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     * HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
     * 주로 @RequestBody, @RequestPart 어노테이션에서 발생
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected MethodArgumentNotValidException handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return e;
    }

    /**
     * @ModelAttribut 으로 binding error 발생시 BindException 발생한다.
     * ref https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-modelattrib-method-args
     */
    @ExceptionHandler(BindException.class)
    protected BindException handleBindException(BindException e) {
        return e;
    }

    /**
     * enum type 일치하지 않아 binding 못할 경우 발생
     * 주로 @RequestParam enum으로 binding 못했을 경우 발생
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected MethodArgumentTypeMismatchException handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return e;
    }

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected HttpRequestMethodNotSupportedException handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        final ErrorResponse response = ErrorResponse.of(UserMessage.ACCESS_DENIED);
        return e;
    }

    /**
     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected AccessDeniedException handleAccessDeniedException(AccessDeniedException e) {
        return e;
    }

    @ExceptionHandler(BusinessException.class)
    protected BusinessException handleBusinessException(final BusinessException e) {
        return e;
    }

    /**
     * 중요 비즈니스 오류가 발생한 경우
     */
    @ExceptionHandler(CriticalBusinessException.class)
    protected CriticalBusinessException handleCriticalBusinessException(final CriticalBusinessException e) {
        // 중요 비즈니스 오류 처리. 알람 발송 등...
        return e;
    }

    @ExceptionHandler(Exception.class)
    protected Exception handleException(Exception e) {
        // 오류 처리...
        return e;
    }
}
