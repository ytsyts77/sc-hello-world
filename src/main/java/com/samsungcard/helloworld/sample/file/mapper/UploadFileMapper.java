package com.samsungcard.helloworld.sample.file.mapper;

import com.samsungcard.helloworld.sample.file.dto.UploadFileDto;
import com.samsungcard.helloworld.sample.file.entity.UploadFile;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UploadFileMapper {
    UploadFileDto toUploadFileDto(UploadFile uploadFile);
    List<UploadFileDto> toUploadFileDtoList(List<UploadFile> uploadFile);
    UploadFile toUploadFile(UploadFileDto uploadFileDto);
}
