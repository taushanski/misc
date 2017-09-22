package com.jpa.javageek.many_to_one.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.javageek.many_to_one.entity.Department;
import com.jpa.javageek.many_to_one.entity.Employee;

public class ManyToOneTest {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		Employee employee = new Employee();
		employee.setEmail("someMail@gmail.com");
		employee.setFirstname("Prasad");
		employee.setLastname("kharkar");

		txn.begin();
		Department department = new Department();
		department.setName("KiroDep");
		em.persist(department);
		// txn.commit();

		employee.setDepartment(department);

		// txn.begin();
		em.persist(employee);
		txn.commit();

	}

}
