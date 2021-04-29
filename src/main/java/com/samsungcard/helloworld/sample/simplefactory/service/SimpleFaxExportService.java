package com.samsungcard.helloworld.sample.simplefactory.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SimpleFaxExportService implements SimpleExportService {
    @Override
    public String export() {
        log.info("SimpleFaxExportService.export");
        return "fax.file";
    }

    @Override
    public void transfer(String fileName) {
        log.info("SimpleFaxExportService.transfer");
    }

    @Override
    public void deleteLocal(String fileName) {
        log.info("SimpleFaxExportService.deleteLocal");
    }

    @Override
    public SimpleExportType getExportType() {
        return SimpleExportType.FAX;
    }
}
