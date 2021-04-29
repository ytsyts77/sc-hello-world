package com.samsungcard.helloworld.sample.file.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    public void init();

    public String store(MultipartFile file);

    public Resource loadAsResource(String filename);

    public void deleteAll();
}
