package com.spring.emp.dept;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import com.spring.emp.dept.model.Company;
import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.model.Employee;
import com.spring.emp.dept.repository.DepartmentRepository;

@SpringBootTest
class SpringBootJpaOneToManyApplicationTests {

	@Test
	void contextLoads() {
		String args [] = {};
		ConfigurableApplicationContext b = SpringApplication.run(SpringBootJpaOneToManyApplication.class, args);
		DepartmentRepository repo = b.getBean(DepartmentRepository.class);
		Department d =new Department("tys");
		Employee e1 = new Employee("dfg",d);
		Employee e2 = new Employee("wer",d);
		List<Employee> ie = new ArrayList<Employee>();
		ie.add(e1);
		ie.add(e2);
		d.setEmployees(ie);
		repo.save(d);
		
		
	}
	
}
