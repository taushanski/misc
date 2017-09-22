package com.jpa.javageek.entitylisteners.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name = "EmployeeJavaGeekEntityListener")
@Table(name = "EmployeeJavaGeekEntityListener")
@EntityListeners(EmployeeLoggerListener.class)
public class Employee {

	@TableGenerator(name = "employeeel_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, table = "id_gen")
	@Id
	@GeneratedValue(generator = "employeeel_gen", strategy = GenerationType.TABLE)
	private int idEmployee;

	private String firstName;
	private String lastName;
	private int salary;

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}