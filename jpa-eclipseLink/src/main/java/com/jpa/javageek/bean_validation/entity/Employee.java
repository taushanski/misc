package com.jpa.javageek.bean_validation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "EmployeeJavaGeekBeenValidation")
@Table(name = "EmployeeJavaGeekBeenValidation")
public class Employee {

	@TableGenerator(name = "employeeval_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, table = "id_gen")
	@Id
	@GeneratedValue(generator = "employeeval_gen", strategy = GenerationType.TABLE)
	private int idEmployee;

	@NotNull
	@Size(max = 25)
	private String firstName;

	@NotNull(/*message="Must not be null! Hello"*/)
	@Size(max = 25)
	private String lastName;

	@NotNull
	@DecimalMax(value = "50000.00")
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