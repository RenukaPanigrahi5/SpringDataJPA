package com.spring.emp.dept.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.emp.dept.model.Company;
import com.spring.emp.dept.model.EmpDeptSize;
import com.spring.emp.dept.model.Employee;
import com.spring.emp.dept.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping("/createCompany")
	public ResponseEntity<Company>  createNewCompany(@RequestBody Company company) {
		Company comp = companyService.createNewCompany(company);
		return new ResponseEntity<>(comp, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllCompanies")
	public ResponseEntity<List<Company>> getAllCompanies() {
		List<Company> comapniesList = companyService.getAllCompanies();
		return new ResponseEntity<>(comapniesList, HttpStatus.OK);
	}
	
	@GetMapping("/getDepNamesByCompName")
	public ResponseEntity<?> getDepNamesByCompName(@RequestParam(name = "compName") String compName) {
		//List<String> depNamesList = companyService.getDepNamesByCompName(compName);
		List<String> depNamesList = companyService.getDepNamesByCompNameJava8(compName);
		if(null != depNamesList) {
			return new ResponseEntity<>(depNamesList, HttpStatus.OK);
		}
		return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
	}
	
	//Company name as Parameter dept count as output
	@GetMapping("/getDepCountByCompName")
	public ResponseEntity<?> getDepCountByCompName(@RequestParam(name = "compName") String compName) {
		Integer deptCount = companyService.getDCountByCompName(compName);
		return new ResponseEntity<>("Department Count="+deptCount, HttpStatus.OK);
	}

	//Company Name, Dept count as output
	@GetMapping("/getCompNameWithDeptCount")
	public ResponseEntity<Map<String,Integer>>  getCompNameWithDeptCount() {
		Map<String,Integer> compNameWithDeptCount = companyService.getCompNameDeptCount();
		return new ResponseEntity<>(compNameWithDeptCount, HttpStatus.OK);
	}
	
	//Company Name as key, dept count ,emp count as values
	@GetMapping("/getAllCount")
	public ResponseEntity<Map<String,Map<String,Integer>>> getCompNameDeptCountEmpCount(){
		Map<String,Map<String,Integer>> countOfAll = companyService.getCountingAll();
	   return new ResponseEntity<>(countOfAll, HttpStatus.OK);
	}
	
	@GetMapping("/getAllCountPojo")
	public ResponseEntity<Map<String,EmpDeptSize>> getCompNameDeptCountEmpCountPojo(){
		Map<String,EmpDeptSize> countOfAllPojo = companyService.getCountingAllSample();
	   return new ResponseEntity<>(countOfAllPojo, HttpStatus.OK);
	}
	

	
}
