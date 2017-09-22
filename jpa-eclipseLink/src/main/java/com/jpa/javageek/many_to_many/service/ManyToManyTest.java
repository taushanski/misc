package com.jpa.javageek.many_to_many.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.javageek.many_to_many.entity.Employee;
import com.jpa.javageek.many_to_many.entity.Project;

public class ManyToManyTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);

		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Employee prasad = new Employee();
		prasad.setName("prasad kharkar");

		Employee harish = new Employee();
		harish.setName("Harish taware");

		Project ceg = new Project();
		ceg.setName("CEG");

		Project gtt = new Project();
		gtt.setName("GTT");

		List<Project> projects = new ArrayList<Project>();
		projects.add(ceg);
		projects.add(gtt);

		List<Employee> employees = new ArrayList<Employee>();
		employees.add(prasad);
		employees.add(harish);

		ceg.setEmployees(employees);
		gtt.setEmployees(employees);

		prasad.setProjects(projects);
		harish.setProjects(projects);

		em.persist(prasad);

		transaction.commit();
	}
}
