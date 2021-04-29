package com.samsungcard.helloworld.sample.emp.service;


import com.samsungcard.helloworld.sample.emp.repository.DeptRepository;
import com.samsungcard.helloworld.sample.emp.entity.Dept;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class DeptService {
    private final DeptRepository deptRepository;

    @Transactional
    public Dept addDept(Dept dept) {
        return deptRepository.save(dept);
    }
}
