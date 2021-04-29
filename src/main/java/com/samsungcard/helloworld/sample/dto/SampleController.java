package com.samsungcard.helloworld.sample.dto;

import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

public class SampleController {
    @PostMapping("/add")
    public String add(@Valid EmpDto.AddEmpReqDto reqDto) {
        //...
        return null;
    }
}
