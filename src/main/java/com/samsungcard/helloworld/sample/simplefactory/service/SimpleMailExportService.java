package com.samsungcard.helloworld.sample.simplefactory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SimpleMailExportService implements SimpleExportService {
    @Override
    public String export() {
        log.info("SimpleMailExportService.export");
        return "mail.file";
    }

    @Override
    public void transfer(String fileName) {
        log.info("SimpleMailExportService.transfer");
    }

    @Override
    public void deleteLocal(String fileName) {
        log.info("SimpleMailExportService.deleteLocal");
    }

    @Override
    public SimpleExportType getExportType() {
        return SimpleExportType.MAIL;
    }
}
