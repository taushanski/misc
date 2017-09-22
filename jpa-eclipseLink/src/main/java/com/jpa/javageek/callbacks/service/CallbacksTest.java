package com.jpa.javageek.callbacks.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.javageek.callbacks.entity.Employee;

public class CallbacksTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);

		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Employee employee = new Employee();
		employee.setFirstName("prasad");
		employee.setLastName("kharkar");
		employee.setSalary(100000);
		System.out.println("Employee is to be persisted...");
		em.persist(employee);
		System.out.println("Employee has been persisted...");
		int idEmployee = employee.getIdEmployee();
		transaction.commit();

		transaction.begin();

		employee = (Employee) em.find(Employee.class, idEmployee);
		System.out.println("Employee is to be updated...");
		employee.setSalary(employee.getSalary() + 10000);
		System.out.println("Employee has been updated...");
		transaction.commit();

		transaction.begin();
		System.out.println("Employee is to be persisted again...");
		em.persist(employee);
		System.out.println("Employee has been persisted again...");
		System.out.println("Employee is to be removed ...");
		em.remove(employee);
		System.out.println("Employee was removed ...");
		transaction.commit();
	}
}
