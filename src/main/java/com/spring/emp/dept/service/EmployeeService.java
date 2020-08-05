package com.spring.emp.dept.service;

import java.util.List;

import com.spring.emp.dept.model.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee);
    public List<Employee> getAllEmployees();
    public Employee getEmployee(Long employeeId);
    public void deleteEmployee(Long employeeId);
    public void updateEmployee(Employee employee);
}
