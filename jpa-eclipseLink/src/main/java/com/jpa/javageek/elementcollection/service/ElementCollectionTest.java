package com.jpa.javageek.elementcollection.service;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.javageek.elementcollection.element.Course;
import com.jpa.javageek.elementcollection.element.Employee;

public class ElementCollectionTest {
	public static void main(String[] args) {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);

		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Employee prasad = new Employee();
		prasad.setName("Prasad Kharkar");

		Course java = new Course();
		java.setCoursename("java standard edition");
		java.setDescription("Some description about java");

		Course jpa = new Course();
		jpa.setCoursename("jpa");
		jpa.setDescription("some description about jpa");

		Set<Course> courses = prasad.getCourses();

		courses.add(jpa);
		courses.add(java);
		prasad.setCourses(courses);
		em.persist(prasad);

		transaction.commit();
	}
}
