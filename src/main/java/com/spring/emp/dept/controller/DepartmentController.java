package com.spring.emp.dept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.model.Employee;
import com.spring.emp.dept.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;

	/**
	 * create department
	 * @param employeeList
	 * @param deptName
	 * @param company_name
	 * @return created department
	 */
	@PostMapping("/createEmployeeByDept/{deptName}/{company_name}")
	public ResponseEntity<Department> saveEmployeeDept(@RequestBody List<Employee> employeeList,
			@PathVariable String deptName, @PathVariable String company_name) {
		Department dept = deptService.saveEmpsByDeptNameAndCompany(employeeList, deptName, company_name);
		return new ResponseEntity<>(dept, HttpStatus.OK);
	}

	/**
	 *
	 * @param deptId
	 * @return
	 */
	@GetMapping("/getEmpsByDeptId")
	public ResponseEntity<List<Employee>> getEmpsByDeptId(@RequestParam(name = "deptId") Long deptId) {
		System.out.println(deptId);
		List<Employee> empList = deptService.getEmpsByDeptId(deptId);
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

	/**
	 *
	 * @param deptName
	 * @return
	 */
	@GetMapping("/getEmpsByDeptName")
	public ResponseEntity<List<Employee>> getEmpsByDeptName(@RequestParam(name = "deptName") String deptName) {
		List<Employee> empList = deptService.getEmpsByName(deptName);
		return new ResponseEntity<>(empList, HttpStatus.OK);
	}

}
