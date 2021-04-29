package com.samsungcard.helloworld.sample.exception;

import com.samsungcard.helloworld.global.common.message.UserMessage;
import com.samsungcard.helloworld.global.error.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController {
    @GetMapping("/biz")
    public void business() {
        throw new BusinessException(UserMessage.NOT_FOUND, "사원정보");
    }

    @GetMapping("/null")
    public String nullPointer() {
        throw new NullPointerException();
    }
}
