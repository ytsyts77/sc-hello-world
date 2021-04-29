package com.samsungcard.helloworld.sample.emp.repository;

import com.samsungcard.helloworld.sample.emp.entity.Dept;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import settings.setup.IntegrationTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmpCustomRepositoryTest extends IntegrationTest {
    @Autowired
    EmpRepository empRepository;
    @Autowired
    DeptRepository deptRepository;

    @Test
    @DisplayName("email 로 like 검색 CustomRepository 동작 확인")
    void test01() {
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

        deptRepository.save(dept);
        empRepository.save(emp);

        //when
        List<Emp> resultList = empRepository.findContainsEmailWithDept("test");

        //then
        assertEquals(1, resultList.size());
        assertEquals("길동", resultList.get(0).getFirstName());
        assertEquals("테스트 부서", resultList.get(0).getDept().getName());
    }
}
