package com.samsungcard.helloworld.sample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService1 {
    private final SampleService2 sampleService2;

    ///...
}
