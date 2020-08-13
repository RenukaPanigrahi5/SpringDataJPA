package com.spring.emp.dept.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.emp.dept.model.Company;
import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.model.Employee;

public class ObjectToJSONConverter {
	
	public static String getJSONFormatForCompany() {
		Company c = new Company("amazon");
		List<Department> depList = new ArrayList<>();
		
		Department d =new Department("tys");
		Employee e1 = new Employee("dfg",d);
		Employee e2 = new Employee("wer",d);
		List<Employee> ie = new ArrayList<Employee>();
		ie.add(e1);
		ie.add(e2);
		d.setEmployees(ie);
		
		depList.add(d);
		c.setDep(depList);
		
		ObjectMapper mapper = new ObjectMapper();
	     String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(c);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jsonString;
	}
}
