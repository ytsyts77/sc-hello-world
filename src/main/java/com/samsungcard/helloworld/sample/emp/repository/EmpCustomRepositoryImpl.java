package com.samsungcard.helloworld.sample.emp.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsungcard.helloworld.sample.emp.entity.QDept;
import com.samsungcard.helloworld.sample.emp.entity.QEmp;
import com.samsungcard.helloworld.sample.emp.entity.Emp;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmpCustomRepositoryImpl implements EmpCustomRepository {
    private final JPAQueryFactory query;

    @Override
    public List<Emp> findContainsEmailWithDept(String email) {
        QEmp e = QEmp.emp;
        QDept d = QDept.dept;

        return query.selectFrom(e)
                .innerJoin(e.dept, d)
                .where(e.email.contains(email))
                .fetch();
    }
}
