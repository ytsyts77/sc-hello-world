package com.samsungcard.helloworld.sample.emp.repository;


import com.samsungcard.helloworld.sample.emp.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Long> {
}
