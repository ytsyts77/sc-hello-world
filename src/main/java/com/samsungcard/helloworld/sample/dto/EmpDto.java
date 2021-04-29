package com.samsungcard.helloworld.sample.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmpDto {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AddEmpReqDto {
        @NotBlank
        private String firstName;

        @NotBlank
        private String lastName;

        @NotBlank
        @Email
        private String email;

        @Builder
        public AddEmpReqDto(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AddEmpResDto {
        private Long id;

        @Builder
        public AddEmpResDto(Long id) {
            this.id = id;
        }
    }
}
