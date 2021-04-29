package com.samsungcard.helloworld.controller;

import settings.setup.IntegrationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class HelloControllerTest extends IntegrationTest {
    @Test
    @DisplayName("초기 페이지 로딩")
    void hello() throws Exception {
        //given
        String urlTemplate = "/";

        //when
        ResultActions resultActions = mockMvc
                .perform(get(urlTemplate))
                .andDo(print());

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }
}
