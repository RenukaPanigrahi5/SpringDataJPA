package com.spring.emp.dept.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Company_Id")
	private List<Department> dep = new ArrayList<>();
	
	private String name;
	
	public Company(String name) {
		super();
		this.name = name;
	}

	public Company(Long id) {
		super();
		this.id = id;
	}
	
	public Company() {
		super();
	}


	public String getName() {
		return name;
	}


	public Company(List<Department> dep, String name) {
		super();
		this.dep = dep;
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Department> getDep() {
		return dep;
	}

	public void setDep(List<Department> dep) {
		this.dep = dep;
	}

}
