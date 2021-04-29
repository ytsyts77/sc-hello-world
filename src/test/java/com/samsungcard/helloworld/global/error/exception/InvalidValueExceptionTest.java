package com.samsungcard.helloworld.global.error.exception;

import com.samsungcard.helloworld.global.common.message.UserMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvalidValueExceptionTest {
    @Test
    @DisplayName("사원번호 유효성 오류 확인")
    void InvalidValueException_파라미터() {
        //given
        BusinessException e = new InvalidValueException(UserMessage.INVALID_INPUT, "사원번호");

        //when
        try{
            throw e;
        } catch (InvalidValueException ex){
            //then
            assertEquals(UserMessage.INVALID_INPUT, ex.getUserMessage());
            assertEquals("사원번호(은/는) 유효하지 않은 입력값 입니다.", ex.getMessage());
        }
    }
}
