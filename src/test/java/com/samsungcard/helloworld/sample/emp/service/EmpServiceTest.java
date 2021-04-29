package com.samsungcard.helloworld.sample.emp.service;


import com.samsungcard.helloworld.sample.emp.dto.EmpDto;
import com.samsungcard.helloworld.sample.emp.entity.Dept;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import com.samsungcard.helloworld.sample.emp.mapper.DeptMapper;
import com.samsungcard.helloworld.sample.emp.mapper.EmpMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import settings.setup.IntegrationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmpServiceTest extends IntegrationTest {
    @Autowired
    EmpService empService;

    @Autowired
    DeptService deptService;

    @Autowired
    EmpMapper empMapper;

    @Autowired
    DeptMapper deptMapper;

    @Test
    @DisplayName("사원 등록")
    void add() {
        //given
        Dept dept = Dept.builder()
                .name("테스트 부서")
                .build();

        EmpDto empDto = EmpDto.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .build();

        Emp emp = empMapper.toEntity(empDto);

        //when
        deptService.addDept(dept);
        emp.setDept(dept);
        empService.add(emp);

        //then
        assertEquals(emp, empService.find(emp.getId()));
    }
}
