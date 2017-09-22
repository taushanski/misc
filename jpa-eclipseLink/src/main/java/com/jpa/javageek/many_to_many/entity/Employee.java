package com.jpa.javageek.many_to_many.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name = "EmployeeJavaGeekMTM")
@Table(name = "EmployeeJavaGeekMTM")
public class Employee {

	@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
	private int idemployee;
	private String name;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "idemployee_fk"), inverseJoinColumns = @JoinColumn(name = "idproject_fk"))
	private List<Project> projects;

	public int getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}