package com.samsungcard.helloworld.sample.emp.repository;


import com.samsungcard.helloworld.sample.emp.entity.Emp;

import java.util.List;

public interface EmpCustomRepository {
    public List<Emp> findContainsEmailWithDept(String email);
}
