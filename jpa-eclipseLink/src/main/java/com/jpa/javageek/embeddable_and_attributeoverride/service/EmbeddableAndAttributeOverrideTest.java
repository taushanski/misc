package com.jpa.javageek.embeddable_and_attributeoverride.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.javageek.embeddable_and_attributeoverride.entity.Address;
import com.jpa.javageek.embeddable_and_attributeoverride.entity.Office;
import com.jpa.javageek.embeddable_and_attributeoverride.entity.Person;

public class EmbeddableAndAttributeOverrideTest {
	public static void main(String[] args) {
		/* Create EntityManagerFactory */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);

		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();

		Person prasad = new Person();
		prasad.setName("prasad");

		Address address = new Address();
		address.setArea("Pimple Saudagar");
		address.setCity("pune");
		address.setPincode("411 027");

		prasad.setAddress(address);

		em.persist(prasad);

		Office office = new Office();
		office.setAddress(address);

		em.persist(office);

		transaction.commit();
	}
}
