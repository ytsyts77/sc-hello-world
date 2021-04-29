package com.samsungcard.helloworld.sample.emp.controller;


import com.samsungcard.helloworld.sample.emp.dto.EmpDto;
import com.samsungcard.helloworld.sample.emp.entity.Dept;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import com.samsungcard.helloworld.sample.emp.mapper.EmpMapper;
import com.samsungcard.helloworld.sample.emp.service.DeptService;
import com.samsungcard.helloworld.sample.emp.service.EmpService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.ResultActions;
import settings.setup.IntegrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class EmpControllerTest extends IntegrationTest {
    @Autowired
    EmpService empService;

    @Autowired
    DeptService deptService;

    @Autowired
    EmpMapper empMapper;

    private ResultActions requestGet(String urlTemplate) throws Exception {
        return mockMvc.perform(get(urlTemplate))
                .andDo(print());
    }

    @BeforeEach
    void beforeEach(){
        Dept dept = Dept.builder()
                .name("테스트 부서")
                .build();

        EmpDto empDto = EmpDto.builder()
                .firstName("길동")
                .lastName("홍")
                .email("test@email.com")
                .build();

        Emp emp = empMapper.toEntity(empDto);

        deptService.addDept(dept);
        emp.setDept(dept);
        empService.add(emp);
    }

    @Test
    @DisplayName("사원 등록 화면")
    void viewEdit() throws Exception {
        //given
        String urlTemplate = "/emp/edit";

        //when
        ResultActions resultActions = requestGet(urlTemplate);

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("emp-add-edit"));
    }

    @Test
    @DisplayName("사원 수정 화면 열기")
    void editEmpById() throws Exception {
        //given
        String urlTemplate = "/emp/edit/1";

        //when
        ResultActions resultActions = requestGet(urlTemplate);

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("emp-add-edit"));
    }

    @Test
    @DisplayName("사원 목록 조회")
    void getAll() throws Exception {
        //given
        String urlTemplate = "/emp/list";

        //when
        ResultActions resultActions = requestGet(urlTemplate);

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("emp-list"));
    }

    @Test
    @DisplayName("사원 삭제")
    void remove() {
    }

    @Test
    @DisplayName("사원 추가")
    void add() {
    }
}
