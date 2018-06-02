package com.sap.spring.example.bean;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class WebShop {

	@Inject
//	@Qualifier("creditCheckImpl")
	private CreditCheck creditCheck;

	public WebShop() {
		System.out.println("Constructor for WebShop");
	}

	public void check() {
		if (creditCheck != null) {
			creditCheck.check();
		} else {
			System.out.println("No CreditCheck implementation provided!!!");
		}
	}

}
