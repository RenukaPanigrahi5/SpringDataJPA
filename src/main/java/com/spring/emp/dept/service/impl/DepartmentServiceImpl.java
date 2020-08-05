package com.spring.emp.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.model.Employee;
import com.spring.emp.dept.repository.DepartmentRepository;
import com.spring.emp.dept.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveEmpsByDeptName(List<Employee> employeeList, String deptName) {

		Department d = new Department(deptName);
		for (Employee employee : employeeList) {
			employee.setDepartment(d);
		}
		d.setEmployees(employeeList);
		return departmentRepository.save(d);
	}

	@Override
	public List<Employee> getEmpsByDeptId(Long deptId) {
		Department dept = departmentRepository.findById(deptId).orElse(null);
		if (dept != null) {
			return dept.getEmployees();
		}
		return null;
	}

	@Override
	public List<Employee> getEmpsByName(String deptName) {
		Department dept = departmentRepository.findByName(deptName);
		if (dept != null) {
			return dept.getEmployees();
		}
		return null;
	}

}
