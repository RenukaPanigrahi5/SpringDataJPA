package com.spring.emp.dept.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.model.Employee;
import com.spring.emp.dept.repository.DepartmentRepository;
import com.spring.emp.dept.repository.EmployeeRepository;
import com.spring.emp.dept.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		Department dept = departmentRepository.findById(employee.getDepartment().getId()).orElse(null);
		if (null == dept) {
			dept = new Department();
		}
		dept.setName(employee.getDepartment().getName());
		employee.setDepartment(dept);
		return employeeRepository.save(employee);
	}

	public Employee saveEmployees(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployees(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		Employee emp = employeeRepository.findById(employeeId).orElse(null);
		return emp;
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

}
