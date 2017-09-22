package com.jpa.javageek.secondaryTable.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Constants;

public class SecondaryTableTest {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);

	static EntityManager em = emf.createEntityManager();

	public static void main(String[] a) throws Exception {
		em.getTransaction().begin();

		Employee emp = new Employee();
		emp.setFirstName("Prasad");
		emp.setLastName("Kharkar");
		emp.setEmail("prasad_kharkar@abc.com");
		em.persist(emp);

		emp = new Employee();
		emp.setFirstName("Sushant");
		emp.setLastName("Pangarkar");
		emp.setSalary(800000);
		em.persist(emp);

		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}
