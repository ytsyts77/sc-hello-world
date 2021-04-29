package com.samsungcard.helloworld.sample.simplefactory.service;

public interface SimpleExportService {
    String export();

    void transfer(String fileName);

    void deleteLocal(String fileName);

    SimpleExportType getExportType();
}
