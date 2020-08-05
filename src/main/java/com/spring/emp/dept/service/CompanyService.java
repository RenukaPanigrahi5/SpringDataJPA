package com.spring.emp.dept.service;

import java.util.List;

import com.spring.emp.dept.model.Company;

public interface CompanyService {
	Company createNewCompany(Company company);
	List<Company> getAllCompanies();
	List<String> getDepNamesByCompName(String compName);
	
}
