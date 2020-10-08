package com.spring.emp.dept.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.emp.dept.model.Company;
import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.model.Employee;
import com.spring.emp.dept.repository.DepartmentRepository;
import com.spring.emp.dept.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	/**
	 * creating department
	 * @param employeeList
	 * @param deptName
	 * @param companyName
	 * @return created department
	 */
	@Override
	public Department saveEmpsByDeptNameAndCompany(List<Employee> employeeList, String deptName, String companyName) {
		Company c = new Company(companyName);
		Department d = new Department(deptName);
		d.setCompany(c);
		for (Employee employee : employeeList) {
			employee.setDepartment(d);
		}
		d.setEmployees(employeeList);
		return departmentRepository.save(d);
	}

	/**
	 *
	 * @param deptId
	 * @return
	 */
	@Override
	public List<Employee> getEmpsByDeptId(Long deptId) {
		Department dept = departmentRepository.findById(deptId).orElse(null);
		if (Objects.nonNull(dept)) {
			return dept.getEmployees();
		}
		return Collections.emptyList();
	}

	/**
	 *
	 * @param deptName
	 * @return
	 */
	@Override
	public List<Employee> getEmpsByName(String deptName) {
		Department dept = departmentRepository.findByName(deptName);
		if (Objects.nonNull(dept)) {
			return dept.getEmployees();
		}
		return Collections.emptyList();
	}
}
