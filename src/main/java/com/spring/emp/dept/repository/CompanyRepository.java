package com.spring.emp.dept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.emp.dept.model.Company;
import com.spring.emp.dept.model.Department;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	Company findByName(String deptName);
}
