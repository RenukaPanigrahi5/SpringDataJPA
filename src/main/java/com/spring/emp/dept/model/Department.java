package com.spring.emp.dept.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Department")
@Builder(toBuilder = true)
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String name;


	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	@Setter
	@Getter
	private List<Employee> employees = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonBackReference
	@Getter
	@Setter
	private Company company;

}
