package com.samsungcard.helloworld.sample.factorymethod.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailGifExportService implements ExportService {
    @Override
    public String export() {
        log.info("MailGifExportService.export");
        return "mail.gif";
    }

    @Override
    public void transfer(String fileName) {
        log.info("MailGifExportService.transfer");
    }

    @Override
    public void deleteLocal(String fileName) {
        log.info("MailGifExportService.deleteLocal");
    }

    @Override
    public ExportType getExportType() {
        return ExportType.GIF;
    }

    @Override
    public TargetType getTargetType() {
        return TargetType.MAIL;
    }
}
