package com.spring.emp.dept.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.emp.dept.model.Company;
import com.spring.emp.dept.model.Department;
import com.spring.emp.dept.model.EmpDeptSize;
import com.spring.emp.dept.model.Employee;
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
		List<Company> listOfComp = companyRepository.findAll();
		/*return listOfComp.stream().
				forEach(company -> company.getDep().stream().collect(Collectors.toList()).
								forEach(department -> department.getEmployees().
										stream(Collectors.toList()));*/
		for (Company company : listOfComp) {
			List<Department> deptList = company.getDep();
			for (Department department : deptList) {
				List<Employee> emList = department.getEmployees();
			}
		}
		return listOfComp;
	}

	//Completed Java8 Method
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

	@Override
	public List<String> getDepNamesByCompNameJava8(String compName) {
		Optional<Company> c = Optional.ofNullable(companyRepository.findByName(compName));
		List<String> depNames = null;
		if (c.isPresent()) {
			depNames = c.get().getDep().stream().
					map(department -> department.getName()).collect(Collectors.toList());
		}
		return depNames;
	}

	@Override
	public Integer getDCountByCompName(String compName) {
		Company companyName = companyRepository.findByName(compName);
		List<Department> dept = companyName.getDep();
		int count =  dept.size();
		return count;
	}

	//comp name dept count
	@Override
	public Map<String, Integer> getCompNameDeptCount() {
		List<Company> compList = companyRepository.findAll();
		Map<String,Integer> hm = new HashMap<>();
		for (Company company : compList) {
			String compName = company.getName();
			List<Department> deptList = company.getDep();
			hm.put(compName, deptList.size());
		}
		return hm;
	}

	//compName deptCount EmpCount as value
	@Override
	public Map<String, Map<String, Integer>> getCountingAll() {
		Map<String,Map<String,Integer>> hm = new HashMap<>();
		List<Company> compList = companyRepository.findAll();
		for (Company company : compList) {
			Map<String,Integer> mapObj = new HashMap<>();
			String compName = company.getName();
			List<Department> deptList = company.getDep();
			int empSize=0;
		   for (Department department : deptList) {
			 int temp = department.getEmployees().size();
			 empSize+=temp;
			}
		   mapObj.put("deptCount",deptList.size());
		   mapObj.put("empCount",empSize);
		   hm.put(compName, mapObj);
		}
		
		return hm;
	}
	
	
	public Map<String,EmpDeptSize> getCountingAllSample() {
		Map<String,EmpDeptSize> hm = new HashMap<>();
		List<Company> compList = companyRepository.findAll();
		for (Company company : compList) {
			EmpDeptSize e = new EmpDeptSize();
			String compName =  company.getName();
			List<Department> deptList = company.getDep();
			e.setDeptSize(deptList.size());
			int empSize =0;
			for (Department department : deptList) {
				int temp=department.getEmployees().size();
				empSize+=temp;
			}
			e.setEmpSize(empSize);
			hm.put(compName,e);
		}
		
		return hm;
	}

}

