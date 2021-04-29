package com.samsungcard.helloworld.sample.emp.service;

import com.samsungcard.helloworld.global.error.exception.BusinessException;
import com.samsungcard.helloworld.sample.emp.dto.EmpDto;
import com.samsungcard.helloworld.sample.emp.entity.Dept;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import com.samsungcard.helloworld.sample.emp.mapper.EmpMapper;
import com.samsungcard.helloworld.sample.emp.repository.EmpRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import settings.setup.MockTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;

class EmpServiceMockTest extends MockTest {
    @Mock
    EmpRepository empRepository;

    @Mock
    EmpMapper empMapper;

    @InjectMocks
    EmpService empService;

    @Test
    @DisplayName("id 로 조회하여 조회 결과가 없을 때")
    void test04() {
        //given
        given(empRepository.findById(any())).willReturn(Optional.empty());

        //expect
        assertThrows(BusinessException.class, () -> {
            empService.find(1L);
        });
    }

    @Test
    @DisplayName("id 로 조회하여 조회 결과가 있을 때")
    void test03() {
        //given
        Dept dept = Dept.builder()
                .name("테스트 부서")
                .build();

        Emp emp = Emp.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .dept(dept)
                .build();

        EmpDto empDto = EmpDto.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .build();

        given(empRepository.findById(any())).willReturn(Optional.ofNullable(emp));

        //when
        Emp findEmp = empService.find(1L);

        //then
        assertEquals("길동", findEmp.getFirstName());
        assertEquals("홍", findEmp.getLastName());
        assertEquals("test@email.com", findEmp.getEmail());
    }

    @Test
    @DisplayName("insert 성공했을 때")
    void test01() {
        //given
        Emp emp = Emp.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .build();
        emp.setId(1L);

        given(empRepository.save((Emp) any())).willReturn(emp);

        //expect
        empService.add(emp);
    }
}
