package com.samsungcard.helloworld.sample.emp.repository;


import com.samsungcard.helloworld.sample.emp.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Long>, EmpCustomRepository {
}
