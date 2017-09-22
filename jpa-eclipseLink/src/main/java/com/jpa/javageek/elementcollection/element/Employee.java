package com.jpa.javageek.elementcollection.element;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name = "EmployeeJavaGeekElementCollection")
@Table(name = "EmployeeJavaGeekElementCollection")
public class Employee {

	@TableGenerator(name = "employeeElCollection_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employeeElCollection_gen")
	private int idemployee;
	private String name;

	@ElementCollection
	@CollectionTable(name = "employee_courses", joinColumns = @JoinColumn(name = "idemployee"))
	private Set<Course> courses = new HashSet<Course>();

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

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}