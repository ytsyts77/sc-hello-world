package com.samsungcard.helloworld.sample.mock;

import com.samsungcard.helloworld.sample.emp.dto.EmpDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import settings.setup.MockTest;

import static org.junit.jupiter.api.Assertions.*;

public class SampleMockTest extends MockTest {
    @Mock
    EmpDto dto;

    @Test
    @DisplayName("mocking 정상 확인")
    void test(){
        assertNotNull(dto);
    }
}
