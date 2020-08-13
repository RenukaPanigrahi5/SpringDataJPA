package com.spring.emp.dept;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.emp.dept.model.Company;
import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.model.Employee;
import com.spring.emp.dept.repository.CompanyRepository;
import com.spring.emp.dept.repository.DepartmentRepository;


@SpringBootApplication
public class SpringBootJpaOneToManyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext b = SpringApplication.run(SpringBootJpaOneToManyApplication.class, args);
		//SpringApplication.run(SpringBootJpaOneToManyApplication.class, args);
		loadIntialCompanyData(b);
		loadIntialDeptData(b);
	}
	
	private static void loadIntialCompanyData(ConfigurableApplicationContext b ) {
		CompanyRepository repo = b.getBean(CompanyRepository.class);
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
		repo.save(c);
		ObjectMapper mapper = new ObjectMapper();
		 String jsonString;
		try {
			jsonString = mapper.writeValueAsString(c);
			System.out.println(jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
	}
	

	private static void loadIntialDeptData(ConfigurableApplicationContext b ) {
		DepartmentRepository repo = b.getBean(DepartmentRepository.class);
		Company c = new Company("Flipkart");
		Department d =new Department("Hiring");
		Employee e1 = new Employee("Fed",d);
		Employee e2 = new Employee("Maddy",d);
		List<Employee> ie = new ArrayList<Employee>();
		ie.add(e1);
		ie.add(e2);
		d.setEmployees(ie);
		d.setCompany(c);
		repo.save(d);
	}

}
