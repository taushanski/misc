package com.jpa.javageek.secondaryTable.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "EMPLOYEEJavaGeekST")
@Table(name = "EMPLOYEEJavaGeekST")
@SecondaryTable(name = "EMPLOYEE_DETAILS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "EMPLOYEE_ID"))
public class Employee {

	@TableGenerator(name = "employeest_gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employeest_gen")
	private int idemployee;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME", table = "EMPLOYEEJavaGeekST")
	private String lastName;

	@Column(name = "EMAILID", table = "EMPLOYEE_DETAILS")
	private String email;

	@Column(table = "EMPLOYEE_DETAILS")
	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	@Column(table = "EMPLOYEE_DETAILS")
	private double salary;

	public int getIdemployee() {
		return idemployee;
	}

	public void setIdemployee(int idemployee) {
		this.idemployee = idemployee;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}