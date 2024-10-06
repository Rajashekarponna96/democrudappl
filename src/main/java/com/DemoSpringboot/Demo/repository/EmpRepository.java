package com.DemoSpringboot.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DemoSpringboot.Demo.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long> {

}
