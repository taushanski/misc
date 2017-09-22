package com.jpa.javageek.one_to_one.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.javageek.one_to_one.entity.Desk;
import com.jpa.javageek.one_to_one.entity.Employee;

public class OneToOneTest {
	public static void main(String[] args) {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);

		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Employee employee = new Employee();
		employee.setFirstname("pranil");
		employee.setLastname("gilda");
		employee.setEmail("sdfsdf");
		Desk desk = new Desk();
		desk.setLocation("dummy");
		desk.setNumber(59);
		em.persist(desk);
		employee.setDesk(desk);

		em.persist(employee);
		desk.setEmployee(employee);

		em.getTransaction().commit();
		System.out.println(desk.getEmployee());
	}
}
