package com.samsungcard.helloworld.sample.factorymethod.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailPdfExportService implements ExportService {
    @Override
    public String export() {
        log.info("MailPdfExportService.export");
        return "mail.pdf";
    }

    @Override
    public void transfer(String fileName) {
        log.info("MailPdfExportService.transfer");
    }

    @Override
    public void deleteLocal(String fileName) {
        log.info("MailPdfExportService.deleteLocal");
    }

    @Override
    public ExportType getExportType() {
        return ExportType.PDF;
    }

    @Override
    public TargetType getTargetType() {
        return TargetType.MAIL;
    }
}
