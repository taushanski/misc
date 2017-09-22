package com.jpa.javageek.callbacks.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

@Entity(name = "EmployeeJavaGeekCallbacks")
@Table(name = "EmployeeJavaGeekCallbacks")
public class Employee {

	@TableGenerator(name = "employeeCallbacks_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, table = "id_gen")
	@Id
	@GeneratedValue(generator = "employeeCallbacks_gen", strategy = GenerationType.TABLE)
	private int idEmployee;

	private String firstName;
	private String lastName;
	private int salary;

	@NotNull(message = "Dummy must not be null")
	private String dummy;

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

	@PrePersist
	public void methodInvokedBeforePersist() {
		System.out.println("Invoked before persisting employee");
	}

	@PostPersist
	public void methodInvokedAfterPersist() {
		System.out.println("Invoked after persisting employee");
	}

	@PreUpdate
	public void methodInvokedBeforeUpdate() {
		System.out.println("Invoked before updating employee");
	}

	@PostUpdate
	public void methodInvokedAfterUpdate() {
		System.out.println("Invoked after updating employee");
	}

	@PreRemove
	public void methodInvokedBeforeRemove() {
		System.out.println("Invoked before removing employee");
	}

	@PostRemove
	public void methodInvokedAfterRemove() {
		System.out.println("Invoked after removing employee");
	}

	public String getDummy() {
		return dummy;
	}

	public void setDummy(String dummy) {
		this.dummy = dummy;
	}

}