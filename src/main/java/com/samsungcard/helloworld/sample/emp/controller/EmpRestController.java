package com.samsungcard.helloworld.sample.emp.controller;

import com.samsungcard.helloworld.sample.emp.dto.EmpDto;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import com.samsungcard.helloworld.sample.emp.mapper.EmpMapper;
import com.samsungcard.helloworld.sample.emp.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emp")
@RequiredArgsConstructor
public class EmpRestController {
    private final EmpService empService;
    private final EmpMapper empMapper;

    @GetMapping
    public ResponseEntity<List<EmpDto>> getAll() {
        List<EmpDto> list = empMapper.toEmpDto(empService.listAll());
        if (list.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmpDto> getData(@PathVariable Long id) {
        EmpDto empDto = empMapper.toEmpDto(empService.find(id));
        return new ResponseEntity<>(empDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> putData(@RequestBody EmpDto empDto, UriComponentsBuilder ucBuilder) {
        Emp emp = empMapper.toEntity(empDto);
        empService.modify(emp);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/vi/emp/{id}").buildAndExpand(empDto.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> removeData(@PathVariable Long id) {
        empService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> postData(@RequestBody EmpDto empDto, UriComponentsBuilder ucBuilder) {
        Emp emp = empMapper.toEntity(empDto);
        empService.add(emp);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/vi/emp/{id}").buildAndExpand(empDto.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
