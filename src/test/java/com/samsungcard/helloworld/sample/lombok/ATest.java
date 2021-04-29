package com.samsungcard.helloworld.sample.lombok;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATest {
    @Test
    @DisplayName("양방향 참조시 @ToString 오류 발생")
    void test(){
        assertThrows(StackOverflowError.class, () -> {
            new A().toString();
        });
    }
}
