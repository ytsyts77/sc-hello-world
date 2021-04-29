package com.samsungcard.helloworld.sample.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.IdGenerator;

import java.util.UUID;

@Configuration
public class FileNameGeneratorConfig {
    @Bean
    IdGenerator fileNameGenerator() {
        return UUID::randomUUID;
    }
}
