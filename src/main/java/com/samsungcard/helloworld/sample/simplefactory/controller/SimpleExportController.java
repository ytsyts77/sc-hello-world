package com.samsungcard.helloworld.sample.simplefactory.controller;

import com.samsungcard.helloworld.sample.simplefactory.service.SimpleExportService;
import com.samsungcard.helloworld.sample.simplefactory.service.SimpleExportServiceFactory;
import com.samsungcard.helloworld.sample.simplefactory.service.SimpleExportType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SimpleExportController {
    private final SimpleExportServiceFactory exportServiceFactory;

    @GetMapping("/simple-factory/send")
    public String send(@RequestParam String type, Model model) {
        SimpleExportService service = exportServiceFactory.getService(SimpleExportType.get(type));
        String fileName = service.export();
        service.transfer(fileName);
        service.deleteLocal(fileName);
        model.addAttribute("fileName", fileName);
        return "export";
    }
}
