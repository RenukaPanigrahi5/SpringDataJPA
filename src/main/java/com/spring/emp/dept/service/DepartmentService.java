package com.spring.emp.dept.service;

import java.util.List;

import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.model.Employee;

public interface DepartmentService {
	Department saveEmpsByDeptNameAndCompany(List<Employee> employeeList, String deptName, String company_name);
	List<Employee> getEmpsByDeptId(Long deptId);
	List<Employee> getEmpsByName(String deptName);
}
