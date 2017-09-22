package com.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
//		int employeeId = Integer.valueOf(args[0]);
//		String employeeName = args[1];
//		int employeeSalary = Integer.valueOf(args[2]);
//		String employeeDeg = args[3];

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Employee employee = new Employee();
		employee.setEid(1204);
		employee.setEname("1asdf");
		employee.setSalary(80000);
		employee.setDeg("Technical Manager");

		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

}
