package com.jpa.javageek.idclass.entity;

import java.io.Serializable;

public class EmployeeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idEmployee;
	private String branchName;

	public EmployeeId() {

	}

	public EmployeeId(String branchName, int idEmployee) {
		this.branchName = branchName;
		this.idEmployee = idEmployee;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public String getBranchName() {
		return branchName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + idEmployee;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeId other = (EmployeeId) obj;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (idEmployee != other.idEmployee)
			return false;
		return true;
	}

}