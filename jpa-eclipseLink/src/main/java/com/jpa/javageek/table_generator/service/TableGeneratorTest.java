package com.jpa.javageek.table_generator.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.javageek.table_generator.entity.Employee;

public class TableGeneratorTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		Employee emp1 = new Employee();
		emp1.setEmail("testemp@emp.com");
		emp1.setFirstname("testName1");
		emp1.setLastname("testLastName1");

		Employee emp2 = new Employee();
		emp2.setEmail("testemp2@emp.com");
		emp2.setFirstname("testName2");
		emp2.setLastname("testLastName2");

		entityManager.persist(emp1);
		entityManager.persist(emp2);

		entityManager.getTransaction().commit();
	}

}
