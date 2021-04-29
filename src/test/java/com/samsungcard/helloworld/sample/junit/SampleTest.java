package com.samsungcard.helloworld.sample.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTest {
    @Test
    @DisplayName("두개의 숫자 더하기")
    void test(){
        //given
        int x = 2;
        int y = 3;

        //when
        int z = x + y;

        //then
        assertEquals(5, z);
    }
}
