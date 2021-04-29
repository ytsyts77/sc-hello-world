package com.samsungcard.helloworld.sample.factorymethod.servicefactory;

import com.samsungcard.helloworld.sample.factorymethod.service.TargetType;
import com.samsungcard.helloworld.sample.factorymethod.service.ExportService;
import com.samsungcard.helloworld.sample.factorymethod.service.ExportType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FaxExportServiceFactory extends ExportServiceFactory {
    private final Map<ExportType, ExportService> serviceMap = new HashMap<>();

    public FaxExportServiceFactory(List<ExportService> serviceList) {
        serviceList.stream()
                .filter(s -> s.getTargetType() == TargetType.FAX)
                .forEach(s -> serviceMap.put(s.getExportType(), s));
    }

    @Override
    protected ExportService getService(ExportType type) {
        return serviceMap.get(type);
    }
}
