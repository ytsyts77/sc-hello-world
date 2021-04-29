package com.samsungcard.helloworld.sample.exception;

import com.samsungcard.helloworld.global.common.message.UserMessage;
import com.samsungcard.helloworld.global.error.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/exception")
public class ExceptionRestController {
    @GetMapping("/biz")
    public void business() {
        throw new BusinessException(UserMessage.NOT_FOUND, "사원번호");
    }

    @GetMapping("/null")
    public String nullPointer() {
        throw new NullPointerException();
    }
}
