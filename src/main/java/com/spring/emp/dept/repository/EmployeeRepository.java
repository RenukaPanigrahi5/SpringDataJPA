package com.spring.emp.dept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.emp.dept.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
