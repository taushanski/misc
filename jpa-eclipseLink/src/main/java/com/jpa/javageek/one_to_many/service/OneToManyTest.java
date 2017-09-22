package com.jpa.javageek.one_to_many.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.Constants;
import com.jpa.javageek.one_to_many.entity.Department;
import com.jpa.javageek.one_to_many.entity.Employee;

public class OneToManyTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constants.PERSISTENCE_UNIT_NAME);

		/* Create EntityManager */
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		transaction.begin();
		Employee employee1 = new Employee();
		employee1.setFirstname("pranil");
		employee1.setLastname("gilda");
		employee1.setEmail("sdfsdf");

		Employee employee2 = new Employee();
		employee2.setFirstname("prasad");
		employee2.setLastname("kharkar");
		employee2.setEmail("dfgfdg");

		em.persist(employee2);
		em.persist(employee1);
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);

		Department department1 = new Department();
		department1.setName("IT");
		department1.setEmployees(employees);

		employee1.setDepartment(department1);
		System.out.println("Before persisting the department id is: " + department1.getIddepartment());
		em.persist(department1);

		int employeeID = employee1.getIdemployee();
		int departmentid = department1.getIddepartment();
		System.out.println("After persisting the department id is: " + department1.getIddepartment());

		transaction.commit();
		transaction.begin();

		Employee employee = em.find(Employee.class, employeeID);
		System.out.println(employee.getDepartment());

		Department department = em.find(Department.class, departmentid);
		System.out.println(department.getEmployees());

		transaction.commit();
	}
}
