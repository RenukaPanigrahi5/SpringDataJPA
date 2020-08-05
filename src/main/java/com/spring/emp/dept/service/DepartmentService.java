package com.spring.emp.dept.service;

import java.util.List;

import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.model.Employee;

public interface DepartmentService {
	Department saveEmpsByDeptName(List<Employee> employeeList, String deptName);
	List<Employee> getEmpsByDeptId(Long deptId);
	List<Employee> getEmpsByName(String deptName);
}
