package com.jpa.javageek.many_to_one.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name = "DepartmentJavaGeekMTO")
@Table(name = "DepartmentJavaGeekMTO")
public class Department {

	@TableGenerator(name = "department_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "department_gen")
	private int iddepartment;
	private String name;

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

	@Override
	public String toString() {
		return "Department [iddepartment=" + iddepartment + ", name=" + name + "]";
	}

}