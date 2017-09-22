package com.jpa.javageek.one_to_one.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Entity implementation class for Entity: DescJavaGeekOTO
 *
 */
@Entity(name = "DescJavaGeekOTO")
@Table(name = "DescJavaGeekOTO")

public class Desk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@TableGenerator(table = "desk_gen", name = "desk_gen", pkColumnName = "gen_name", valueColumnName = "gen_value", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "desk_gen")
	private int iddesk;
	private int number;
	private String location;

	@OneToOne(mappedBy = "desk")
	private Employee employee;

	public int getIddesk() {
		return iddesk;
	}

	public void setIddesk(int iddesk) {
		this.iddesk = iddesk;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
