package com.samsungcard.helloworld.sample.emp.repository;

import com.samsungcard.helloworld.sample.emp.entity.Dept;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import settings.setup.IntegrationTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmpRepositoryTest extends IntegrationTest {
    @Autowired
    EmpRepository empRepository;
    @Autowired
    DeptRepository deptRepository;

    @Test
    @DisplayName("부서명 수정")
    void test09() {
        //given
        Dept dept = Dept.builder()
                .name("테스트 부서")
                .build();

        deptRepository.save(dept);

        //when
        dept.setName("테스트 수정 부서");

        //then
        Optional<Dept> optionalDept = deptRepository.findById(dept.getId());
        assertTrue(optionalDept.isPresent());
        assertEquals(dept, optionalDept.get());
    }

    @Test
    @DisplayName("부서 등록")
    void test08() {
        //given
        Dept dept = Dept.builder()
                .name("테스트 부서")
                .build();

        //when
        deptRepository.save(dept);

        //then
        Optional<Dept> optionalDept = deptRepository.findById(dept.getId());
        assertTrue(optionalDept.isPresent());
        assertEquals(dept, optionalDept.get());
    }

    @Test
    @DisplayName("사원 2명, 부서 등록")
    void test07() {
        //given
        Dept dept = Dept.builder()
                .name("테스트 부서")
                .build();

        Emp emp1 = Emp.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test1@email.com")
                .dept(dept)
                .build();

        Emp emp2 = Emp.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test2@email.com")
                .dept(dept)
                .build();

        //when
        deptRepository.save(dept);
        empRepository.save(emp1);
        empRepository.save(emp2);


        //then
        Optional<Emp> optionalEmp1 = empRepository.findById(emp1.getId());
        Optional<Emp> optionalEmp2 = empRepository.findById(emp2.getId());
        Optional<Dept> optionalDept = deptRepository.findById(dept.getId());
        assertTrue(optionalEmp1.isPresent());
        assertEquals(emp1, optionalEmp1.get());
        assertTrue(optionalEmp2.isPresent());
        assertEquals(emp2, optionalEmp2.get());
        assertTrue(optionalDept.isPresent());
        assertEquals(dept, optionalDept.get());
    }

    @Test
    @DisplayName("사원의 부서 정보 수정")
    void test04() {
        //given
        Dept dept1 = Dept.builder()
                .name("테스트 부서1")
                .build();

        Dept dept2 = Dept.builder()
                .name("테스트 부서2")
                .build();

        Emp emp = Emp.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .dept(dept1)
                .build();

        deptRepository.save(dept1);
        empRepository.save(emp);

        //when
        deptRepository.save(dept2);
        emp.setDept(dept2);

        //then
        Optional<Emp> optionalEmp = empRepository.findById(emp.getId());
        Optional<Dept> optionalDept1 = deptRepository.findById(dept1.getId());
        Optional<Dept> optionalDept2 = deptRepository.findById(dept2.getId());
        assertTrue(optionalEmp.isPresent());
        assertEquals(emp, optionalEmp.get());
        assertTrue(optionalDept1.isPresent());
        assertEquals(dept1, optionalDept1.get());
        assertTrue(optionalDept2.isPresent());
        assertEquals(dept2, optionalDept2.get());
    }

    @Test
    @DisplayName("사원, 부서 등록")
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

        deptRepository.save(dept);
        empRepository.save(emp);

        //when
        emp.setDept(dept);

        //then
        Optional<Emp> optionalEmp = empRepository.findById(emp.getId());
        Optional<Dept> optionalDept = deptRepository.findById(dept.getId());
        assertTrue(optionalEmp.isPresent());
        assertEquals(emp, optionalEmp.get());
        assertTrue(optionalDept.isPresent());
        assertEquals(dept, optionalDept.get());
    }
}
