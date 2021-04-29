package com.samsungcard.helloworld.sample.emp.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EmpDtoTest {
    @Test
    @DisplayName("EqualsAndHashCode 정상 동작 확인")
    void EqualsAndHashCode_test() {
        //given
        EmpDto empDto = EmpDto.builder()
                .firstName("길동")
                .lastName("홍")
                .email("my-mail@samsungcard.com")
                .build();

        Set<EmpDto> list = new HashSet<>();

        list.add(empDto);

        assertTrue(list.contains(empDto));

        //when
        empDto.setEmail("your-mail@samsungcard.com");

        //then
        assertTrue(list.contains(empDto));
    }
}
