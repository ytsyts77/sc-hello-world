package com.samsungcard.helloworld.sample.emp.dto;

import com.samsungcard.helloworld.sample.emp.entity.Dept;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import com.samsungcard.helloworld.sample.emp.mapper.EmpMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import settings.setup.IntegrationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmpMapperTest extends IntegrationTest {
    @Autowired
    EmpMapper empMapper;

    @Test
    @DisplayName("dto -> entity 매핑")
    void toEntity() {
        //given
        EmpDto empDto = EmpDto.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@samsungcard.com")
                .build();

        //when
        Emp entity = empMapper.toEntity(empDto);

        //then
        assertEquals(empDto.getFirstName(), empDto.getFirstName());
        assertEquals(empDto.getLastName(), empDto.getLastName());
        assertEquals(empDto.getEmail(), empDto.getEmail());
    }

    @Test
    @DisplayName("entity -> dto 매핑")
    void toDto() {
        //given
        Dept dept = Dept.builder()
                .name("테스트 부서")
                .build();

        Emp emp = Emp.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@samsungcard.com")
                .dept(dept)
                .build();

        //when
        EmpDto dto = empMapper.toEmpDto(emp);

        //then
        assertEquals(dto.getId(), emp.getId());
        assertEquals(dto.getFirstName(), emp.getFirstName());
        assertEquals(dto.getLastName(), emp.getLastName());
        assertEquals(dto.getEmail(), emp.getEmail());
    }
}
