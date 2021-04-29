package com.samsungcard.helloworld.sample.file.service;

import com.samsungcard.helloworld.sample.file.exception.StorageFileNotFoundException;
import com.samsungcard.helloworld.sample.file.repository.UploadFileRepository;
import com.samsungcard.helloworld.sample.file.dto.UploadFileDto;
import com.samsungcard.helloworld.sample.file.mapper.UploadFileMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UploadFileService {
    private final UploadFileRepository uploadFileRepository;
    private final UploadFileMapper uploadFileMapper;

    public void add(UploadFileDto uploadFileDto) {
        uploadFileRepository.save(uploadFileMapper.toUploadFile(uploadFileDto));
    }

    public List<UploadFileDto> getAll() {
        return uploadFileMapper.toUploadFileDtoList(uploadFileRepository.findAll());
    }

    public String findOriginFileName(String serverFileName) {
        return uploadFileRepository.findByServerFileName(serverFileName)
                .orElseThrow(() -> new StorageFileNotFoundException("파일 읽기중 얘기치 못한 오류가 발생하였습니다. : " + serverFileName))
                .getOriginFileName();
    }
}
