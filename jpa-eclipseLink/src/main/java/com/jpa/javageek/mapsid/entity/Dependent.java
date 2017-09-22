package com.jpa.javageek.mapsid.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "DependentJavaGeekMapsId")
@Table(name = "DependentJavaGeekMapsId")
public class Dependent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DependentId id;

	@ManyToOne
	@MapsId("empId")
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

	public DependentId getId() {
		return id;
	}

	public void setId(DependentId id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	// equals and hashcode implementation
}
