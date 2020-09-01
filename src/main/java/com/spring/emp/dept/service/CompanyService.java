package com.spring.emp.dept.service;

import java.util.List;
import java.util.Map;

import com.spring.emp.dept.model.Company;
import com.spring.emp.dept.model.EmpDeptSize;

public interface CompanyService {
	Company createNewCompany(Company company);
	List<Company> getAllCompanies();
	List<String> getDepNamesByCompName(String compName);
	Integer getDCountByCompName(String compName);
	Map<String,Integer> getCompNameDeptCount();
	Map<String,Map<String,Integer>> getCountingAll();
	Map<String,EmpDeptSize> getCountingAllSample();
	List<String> getDepNamesByCompNameJava8(String compName);
}
