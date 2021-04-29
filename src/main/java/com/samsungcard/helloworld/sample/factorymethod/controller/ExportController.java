package com.samsungcard.helloworld.sample.factorymethod.controller;

import com.samsungcard.helloworld.sample.factorymethod.servicefactory.FaxExportServiceFactory;
import com.samsungcard.helloworld.sample.factorymethod.servicefactory.MailExportServiceFactory;
import com.samsungcard.helloworld.sample.factorymethod.service.ExportType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ExportController {
    private final MailExportServiceFactory mailExportServiceFactory;
    private final FaxExportServiceFactory faxExportServiceFactory;

    @GetMapping("/factory-method/export/mail")
    public String exportMail(@RequestParam String type, Model model) {
        model.addAttribute("fileName", mailExportServiceFactory
                .exportAndTransfer(ExportType.get(type)));
        return "export";
    }

    @GetMapping("/factory-method/export/fax")
    public String exportFax(@RequestParam String type, Model model) {
        model.addAttribute("fileName", faxExportServiceFactory
                .exportAndTransfer(ExportType.get(type)));
        return "export";
    }
}
