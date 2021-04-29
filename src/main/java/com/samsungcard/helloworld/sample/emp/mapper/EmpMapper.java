package com.samsungcard.helloworld.sample.emp.mapper;

import com.samsungcard.helloworld.sample.emp.dto.EmpDto;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpMapper {
    EmpDto toEmpDto(Emp emp);
    List<EmpDto> toEmpDto(List<Emp> emp);
    Emp toEntity(EmpDto empDto);
    List<Emp> toEntity(List<EmpDto> empDto);
}
