package com.samsungcard.helloworld.sample.emp.mapper;

import com.samsungcard.helloworld.sample.emp.dto.DeptDto;
import com.samsungcard.helloworld.sample.emp.entity.Dept;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeptMapper {
    DeptDto toDeptDto(Dept dept);
    List<DeptDto> toDeptDto(List<Dept> deptList);
    Dept toEntity(DeptDto deptDto);
    List<Dept> toEntity(List<DeptDto> deptDtoList);
}
