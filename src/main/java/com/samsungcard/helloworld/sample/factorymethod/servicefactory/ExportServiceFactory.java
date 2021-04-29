package com.samsungcard.helloworld.sample.factorymethod.servicefactory;

import com.samsungcard.helloworld.sample.factorymethod.service.ExportService;
import com.samsungcard.helloworld.sample.factorymethod.service.ExportType;

public abstract class ExportServiceFactory {
    public String exportAndTransfer(ExportType type) {
        ExportService service = getService(type);
        String fileName = service.export();
        service.transfer(fileName);
        service.deleteLocal(fileName);
        return fileName;
    }

    protected abstract ExportService getService(ExportType type);
}
