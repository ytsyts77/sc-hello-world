package com.samsungcard.helloworld.sample.file.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UploadFileDto {
    private Long id;
    private String serverFileName;
    private String originFileName;

    @Builder
    public UploadFileDto(Long id, String serverFileName, String originFileName) {
        this.id = id;
        this.serverFileName = serverFileName;
        this.originFileName = originFileName;
    }}
