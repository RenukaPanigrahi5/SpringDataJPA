package com.spring.emp.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.emp.dept.model.Employee;
import com.spring.emp.dept.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	/**
	 *
	 * @return all employees list
	 */
	@GetMapping("/get-employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	/**
	 * creating employees with given data
	 * @param employee
	 * @return created employee
	 */
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.addEmployee(employee);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	/**
	 * getting employee by Id
	 * @param employeeId
	 * @return employee
	 */
	@GetMapping("/empsById")
	public ResponseEntity<Employee> getEmpsById(@RequestParam(name = "employeeId") Long employeeId) {
		Employee emp = employeeService.getEmployee(employeeId);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	/**
	 *
	 * @param employeeId
	 */
	@DeleteMapping("/deleteEmp")
	public void deleteEmployee(@RequestParam(name = "employeeId") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		System.out.println("Deleted SuccessFully");
	}

	/**
	 *
	 * @param employee
	 * @param employeeId
	 * @return
	 */
	@PutMapping("/updateEmployee/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,
			@PathVariable(name = "employeeId") Long employeeId) {
		Employee emp = employeeService.getEmployee(employeeId);
		if (emp != null) {
			employeeService.updateEmployee(employee);
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

}
