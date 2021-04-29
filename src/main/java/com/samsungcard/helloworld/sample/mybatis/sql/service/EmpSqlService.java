package com.samsungcard.helloworld.sample.mybatis.sql.service;

import com.samsungcard.helloworld.sample.mybatis.sql.repository.EmpSqlRepository;
import com.samsungcard.helloworld.sample.mybatis.sql.entity.Emp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpSqlService {
    private final EmpSqlRepository empSqlRepository;

    public Emp getEmp(Integer empId) {
        return empSqlRepository.selectByPrimaryKey(empId);
    }

    public List<Emp> getAll(){
        return empSqlRepository.selectAll();
    }
}
