package com.samsungcard.helloworld.sample.simplefactory.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SimpleExportTypeTest {
    @Test
    @DisplayName("get 함수 정상 동작 확인")
    void test() {
        assertTrue(SimpleExportType.FAX == SimpleExportType.get("fax"));
        assertTrue(SimpleExportType.MAIL == SimpleExportType.get("mail"));

        assertFalse(SimpleExportType.MAIL == SimpleExportType.get("fax"));
        assertFalse(SimpleExportType.FAX == SimpleExportType.get("mail"));
    }
}
