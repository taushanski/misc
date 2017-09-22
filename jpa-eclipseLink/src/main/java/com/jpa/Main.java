package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.entity.Employee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee employee = new Employee();
		// employee.setFirstname("Pesho");
		// employee.setLastname("Petrov");
		// employee.setEmail("pesho.p@gmail.com");
		// employee.setIdEmployee(1);

		EntityTransaction transaction = entityManager.getTransaction();
		System.out.println("when creating the entity the trancation is: " + transaction);
		transaction.begin();
		entityManager.persist(employee);
		transaction.commit();

		employee = entityManager.find(Employee.class, 1);
		System.out.println(employee);

		// update the entity
		transaction = entityManager.getTransaction();
		System.out.println("when updating the entity the trancation is: " + transaction);
		transaction.begin();
		// employee.setFirstname("PeshoModified");
		System.out.println("Employee after updation :- " + employee);
		transaction.commit();

	}

}
