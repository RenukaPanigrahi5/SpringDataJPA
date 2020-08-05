package com.spring.emp.dept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.emp.dept.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
   Department findByName(String deptName);
}
