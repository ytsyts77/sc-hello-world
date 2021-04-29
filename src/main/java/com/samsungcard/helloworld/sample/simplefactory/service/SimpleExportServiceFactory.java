package com.samsungcard.helloworld.sample.simplefactory.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SimpleExportServiceFactory {
    private final Map<SimpleExportType, SimpleExportService> serviceMap = new HashMap<>();

    public SimpleExportServiceFactory(List<SimpleExportService> serviceList) {
        serviceList.forEach(s -> serviceMap.put(s.getExportType(), s));
    }

    public SimpleExportService getService(SimpleExportType type) {
        return serviceMap.get(type);
    }
}
