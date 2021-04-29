package com.samsungcard.helloworld.sample.file.mapper;

import com.samsungcard.helloworld.sample.file.dto.UploadFileDto;
import com.samsungcard.helloworld.sample.file.entity.UploadFile;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.10 (AdoptOpenJDK)"
)
@Component
public class UploadFileMapperImpl implements UploadFileMapper {

    @Override
    public UploadFileDto toUploadFileDto(UploadFile uploadFile) {
        if ( uploadFile == null ) {
            return null;
        }

        Long id = null;
        String serverFileName = null;
        String originFileName = null;

        id = uploadFile.getId();
        serverFileName = uploadFile.getServerFileName();
        originFileName = uploadFile.getOriginFileName();

        UploadFileDto uploadFileDto = new UploadFileDto( id, serverFileName, originFileName );

        return uploadFileDto;
    }

    @Override
    public List<UploadFileDto> toUploadFileDtoList(List<UploadFile> uploadFile) {
        if ( uploadFile == null ) {
            return null;
        }

        List<UploadFileDto> list = new ArrayList<UploadFileDto>( uploadFile.size() );
        for ( UploadFile uploadFile1 : uploadFile ) {
            list.add( toUploadFileDto( uploadFile1 ) );
        }

        return list;
    }

    @Override
    public UploadFile toUploadFile(UploadFileDto uploadFileDto) {
        if ( uploadFileDto == null ) {
            return null;
        }

        String serverFileName = null;
        String originFileName = null;

        serverFileName = uploadFileDto.getServerFileName();
        originFileName = uploadFileDto.getOriginFileName();

        UploadFile uploadFile = new UploadFile( serverFileName, originFileName );

        return uploadFile;
    }
}
