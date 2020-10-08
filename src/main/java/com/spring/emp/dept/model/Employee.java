package com.spring.emp.dept.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Employee")
@Builder(toBuilder = true)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	@JsonBackReference
	@Getter
	@Setter
	private Department department;

	/**
	 *
	 * @param name
	 * @param department
	 */
	public Employee(String name, Department department) {
		super();
		this.name = name;
		this.department = department;
	}



}
