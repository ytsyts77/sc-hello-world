package com.samsungcard.helloworld.sample.factorymethod.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FaxGifExportService implements ExportService {
    @Override
    public String export() {
        log.info("FaxGifExportService.export");
        return "fax.gif";
    }

    @Override
    public void transfer(String fileName) {
        log.info("FaxGifExportService.transfer");
    }

    @Override
    public void deleteLocal(String fileName) {
        log.info("FaxGifExportService.deleteLocal");
    }

    @Override
    public ExportType getExportType() {
        return ExportType.GIF;
    }

    @Override
    public TargetType getTargetType() {
        return TargetType.FAX;
    }
}
