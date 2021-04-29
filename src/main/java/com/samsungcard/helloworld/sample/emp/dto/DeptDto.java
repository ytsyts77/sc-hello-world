package com.samsungcard.helloworld.sample.emp.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "empList")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DeptDto {
    private Long id;

    @NotBlank(message = "부서명은 반드시 입력해야 합니다.")
    private String name;

    private List<EmpDto> empList;

    @Builder
    public DeptDto(String name) {
        this.name = name;
    }
}
