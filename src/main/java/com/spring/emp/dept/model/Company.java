package com.spring.emp.dept.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

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
public class Company {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	@Getter
	@Setter
	private Long id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Company_Id")
	@Getter
	@Setter
	private List<Department> dep = new ArrayList<>();


	@Getter
	@Setter
	private String name;

}
