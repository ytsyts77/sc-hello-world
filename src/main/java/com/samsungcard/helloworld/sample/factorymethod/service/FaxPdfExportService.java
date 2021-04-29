package com.samsungcard.helloworld.sample.factorymethod.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FaxPdfExportService implements ExportService {
    @Override
    public String export() {
        log.info("FaxPdfExportService.export");
        return "fax.pdf";
    }

    @Override
    public void transfer(String fileName) {
        log.info("FaxPdfExportService.transfer");
    }

    @Override
    public void deleteLocal(String fileName) {
        log.info("FaxPdfExportService.deleteLocal");
    }

    @Override
    public ExportType getExportType() {
        return ExportType.PDF;
    }

    @Override
    public TargetType getTargetType() {
        return TargetType.FAX;
    }
}
