package com.jpa.one_to_one.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.one_to_one.entity.Department;
import com.jpa.one_to_one.entity.Employee;

public class OneToOne {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// Create Department Entity
		Department department = new Department();
		department.setName("Development");

		Department department2 = new Department();
		department2.setName("Development2");
		// Store Department
		entitymanager.persist(department);
		entitymanager.persist(department2);

		// Create Employee Entity
		Employee employee = new Employee();
		employee.setEname("Satish");
		employee.setSalary(45000.0);
		employee.setDeg("Technical Writer");
		employee.setDepartment(department);

		// Store Employee
		entitymanager.persist(employee);
		employee.setDepartment(department2);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}
