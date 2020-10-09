package com.spring.emp.dept;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.emp.dept.model.Company;
import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.model.Employee;

/**
 * Utility class to generate different types of json requests
 * It is for testing purpose
 */
public class ConvertPojoToJSon {

	public static void main(String[] args) {
		//Employee emp = Employee.builder().empName("Deendaya").salary(100).build();
		List<Department> depList = new ArrayList<>();
		Company c = Company.builder().name("amazon").build();
		Department d = Department.builder().name("tys").build();
		Employee e1 = new Employee("dfg",d);
		Employee e2 = new Employee("wer",d);
		List<Employee> ie = new ArrayList<Employee>();
		ie.add(e1);
		ie.add(e2);
		d.setEmployees(ie);
		
		depList.add(d);
		c.setDep(depList);
		
		ObjectMapper mapper = new ObjectMapper();
	     String jsonString;
		try {
			jsonString = mapper.writeValueAsString(d);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
