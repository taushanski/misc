package com.jpa.javageek.one_to_many.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name = "DepartmentJavaGeekOTM")
@Table(name = "DepartmentJavaGeekOTM")
public class Department {

	@TableGenerator(table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", name = "departmentOTM_gen", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "departmentOTM_gen")
	private int iddepartment;
	private String name;

	@OneToMany(mappedBy = "department")
	private List<Employee> employees;

	public int getIddepartment() {
		return iddepartment;
	}

	public void setIddepartment(int iddepartment) {
		this.iddepartment = iddepartment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}