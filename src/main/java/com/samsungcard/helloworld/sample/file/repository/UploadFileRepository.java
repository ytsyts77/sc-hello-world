package com.samsungcard.helloworld.sample.file.repository;

import com.samsungcard.helloworld.sample.file.entity.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {
    Optional<UploadFile> findByServerFileName(String serverFileName);
}
