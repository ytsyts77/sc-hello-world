package com.samsungcard.helloworld.sample.emp.service;

import com.samsungcard.helloworld.sample.emp.repository.EmpRepository;
import com.samsungcard.helloworld.global.common.message.UserMessage;
import com.samsungcard.helloworld.global.error.exception.BusinessException;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import com.samsungcard.helloworld.sample.emp.mapper.EmpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpService {
    private final EmpRepository empRepository;
    private final EmpMapper empMapper;

    @Transactional(readOnly = true)
    public List<Emp> test(String email){
        return empRepository.findContainsEmailWithDept(email);
    }

    @Transactional(readOnly = true)
    public List<Emp> listAll() {
        return empRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Emp find(Long id) {
        return empRepository.findById(id)
                .orElseThrow(() -> new BusinessException(UserMessage.NOT_FOUND));
    }

    @Transactional
    public void modify(Emp emp) {
        Emp findEmp = empRepository.findById(emp.getId())
                .orElseThrow(() -> new BusinessException(UserMessage.NOT_FOUND));
        findEmp.updateName(emp.getFirstName(), emp.getLastName());
        findEmp.updateEmail(emp.getEmail());
        emp = findEmp;
    }

    @Transactional
    public void remove(Long id) {
        empRepository.deleteById(id);
    }

    @Transactional
    public void add(Emp emp) {
        empRepository.save(emp);
    }
}
