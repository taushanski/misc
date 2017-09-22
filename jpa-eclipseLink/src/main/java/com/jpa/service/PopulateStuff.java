package com.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.entity.NonTeachingStaff;
import com.jpa.entity.Staff;
import com.jpa.entity.TeachingStaff;

public class PopulateStuff {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Staff parent = new Staff(5, "Parent");
		// Teaching staff entity
		TeachingStaff ts1 = new TeachingStaff(1, "Gopal", "MSc MEd", "Maths");
		TeachingStaff ts2 = new TeachingStaff(2, "Manisha", "BSc BEd", "English");

		// Non-Teaching Staff entity
		NonTeachingStaff nts1 = new NonTeachingStaff(3, "Satish", "Accounts");
		NonTeachingStaff nts2 = new NonTeachingStaff(4, "Krishna", "Office Admin");

		// storing all entities
		entitymanager.persist(ts1);
		entitymanager.persist(ts2);
		entitymanager.persist(nts1);
		entitymanager.persist(nts2);
		entitymanager.persist(parent);

		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

}
