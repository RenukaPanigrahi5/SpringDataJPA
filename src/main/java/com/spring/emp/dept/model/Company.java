package com.spring.emp.dept.model;

import lombok.*;

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
@Builder(toBuilder = true)
@Data
public class Company {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Company_Id")
	private List<Department> dep = new ArrayList<>();

	private String name;

}
