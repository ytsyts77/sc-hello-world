package com.samsungcard.helloworld.sample.file.service;

import com.samsungcard.helloworld.sample.file.exception.StorageException;
import com.samsungcard.helloworld.sample.file.exception.StorageFileNotFoundException;
import com.samsungcard.helloworld.sample.file.config.StorageProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.IdGenerator;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService {
    private final Path rootLocation;
    private final IdGenerator fileNameGenerator;

    public FileSystemStorageService(StorageProperties properties, IdGenerator fileNameGenerator) {
        this.rootLocation = Paths.get(properties.getLocation());
        this.fileNameGenerator = fileNameGenerator;
    }

    @Override
    public String store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new StorageException("파일 저장이 실패했습니다. 비어있는 파일인지 확인해주세요.");
            }

            String newFileName = fileNameGenerator.generateId().toString();

            Path destinationFile = this.rootLocation.resolve(
                    Paths.get(newFileName))
                    .normalize().toAbsolutePath();

            if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
                throw new StorageException(
                        "지정된 경로 외에는 파일 저장이 불가능 합니다.");
            }

            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile,
                        StandardCopyOption.REPLACE_EXISTING);
            }

            return newFileName;
        } catch (IOException e) {
            throw new StorageException("파일 저장중 얘기치 못한 오류가 발생하였습니다.", e);
        }
    }

    private Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageFileNotFoundException(
                        "파일 읽기중 얘기치 못한 오류가 발생하였습니다. : " + filename);
            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("파일 읽기중 얘기치 못한 오류가 발생하였습니다. : " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("파일 저장소 초기화중 예기치 못한 오류가 발생하였습니다.", e);
        }
    }
}
