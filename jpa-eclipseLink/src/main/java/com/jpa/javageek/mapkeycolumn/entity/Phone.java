package com.jpa.javageek.mapkeycolumn.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name = "PhoneJavaGeekMKC")
@Table(name = "PhoneJavaGeekMKC")
public class Phone {

	@TableGenerator(name = "phone_gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "phone_gen")
	private int idPhone;
	private String phoneNumber;
	private String provider;

	@ManyToOne
	@JoinColumn(name = "KIRO_EMP")
	private Employee owner;

	public int getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(int idPhone) {
		this.idPhone = idPhone;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

}
