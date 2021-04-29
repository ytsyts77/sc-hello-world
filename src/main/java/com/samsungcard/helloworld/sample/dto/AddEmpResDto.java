package com.samsungcard.helloworld.sample.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddEmpResDto {
    private Long id;

    @Builder
    public AddEmpResDto(Long id) {
        this.id = id;
    }
}
