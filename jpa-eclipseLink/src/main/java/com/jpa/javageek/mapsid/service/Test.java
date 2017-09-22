package com.jpa.javageek.mapsid.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.javageek.mapsid.entity.Dependent;
import com.jpa.javageek.mapsid.entity.DependentId;
import com.jpa.javageek.mapsid.entity.Employee;

public class Test {

	public static EntityManagerFactory emf;
	public static EntityManager em;

	public static void main(String[] args) {

		emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();

		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Employee employee = new Employee();
		employee.setName("Prasad Kharkar");

		DependentId id = new DependentId();
		id.setName("Sushant");

		Dependent dependent = new Dependent();
		dependent.setId(id);

		dependent.setEmployee(employee);

		em.persist(employee);
		em.persist(dependent);
		txn.commit();
		em.close();
		emf.close();
	}

}