package com.jpa.javageek.entitylisteners.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.javageek.entitylisteners.entity.Employee;

public class EntityListenersTest {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Employee employee = new Employee();
		employee.setFirstName("prasad");
		employee.setLastName("kharkar");
		employee.setSalary(100000);

		entityManager.persist(employee);
		int idEmployee = employee.getIdEmployee();
		transaction.commit();

		transaction.begin();

		employee = (Employee) entityManager.find(Employee.class, idEmployee);
		employee.setSalary(employee.getSalary() + 10000);
		transaction.commit();

		transaction.begin();
		entityManager.persist(employee);
		entityManager.remove(employee);
		transaction.commit();
	}
}
