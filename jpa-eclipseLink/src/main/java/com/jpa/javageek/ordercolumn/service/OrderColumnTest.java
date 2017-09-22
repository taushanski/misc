package com.jpa.javageek.ordercolumn.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.javageek.ordercolumn.entity.Employee;

public class OrderColumnTest {
	public static EntityManagerFactory emf;
	public static EntityManager em;

	public static void main(String[] args) {

		emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();

		EntityTransaction txn = em.getTransaction();
		txn.begin();

		Employee emp = new Employee();
		emp.setFirstName("Prasad");
		emp.setLastName("Kharkar");

		List<String> phones = new ArrayList<String>();
		phones.add("353745415");
		phones.add("225765367");
		phones.add("92573626726");
		emp.setPhones(phones);

		em.persist(emp);
		txn.commit();

		int id = emp.getIdEmployee();

		emp = em.find(Employee.class, id);

		phones = emp.getPhones();

		for (String s : phones) {
			System.out.println(s);
		}

		em.close();
		emf.close();
	}
}
