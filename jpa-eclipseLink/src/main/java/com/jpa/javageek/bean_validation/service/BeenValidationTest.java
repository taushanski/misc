package com.jpa.javageek.bean_validation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.jpa.javageek.bean_validation.entity.Employee;

public class BeenValidationTest {
	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setFirstName("prasad");
		employee.setSalary(10000000);

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Employee>> constraints = validator.validate(employee);
		for (ConstraintViolation<Employee> constraint : constraints) {
			System.out.println(constraint.getPropertyPath() + "  " + constraint.getMessage());
		}
	}
}
