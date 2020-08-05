package com.spring.emp.dept.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.emp.dept.model.Company;
import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.repository.CompanyRepository;
import com.spring.emp.dept.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Company createNewCompany(Company company) {
		companyRepository.save(company);
		return companyRepository.save(company);
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public List<String> getDepNamesByCompName(String compName) {
		
		Company c = companyRepository.findByName(compName);
		List<String> depNames = null;
		if(null != c) {
			depNames = new ArrayList<String>();
			List<Department> depList = c.getDep();
			for (Department department : depList) {
				depNames.add(department.getName());
			}
		}
		return depNames;
	}

}

