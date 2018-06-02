package com.sap.spring.example.impl;

import com.sap.spring.example.bean.CreditCheck;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("cloud")
@Component
public class CreditCheckImpl2 implements CreditCheck {

	public CreditCheckImpl2() {
		System.out.println("Constructor for" + getClass().getName());
	}

	@Override
	public void check() {
		System.out.println(getClass().getName() + ".check()");
	}
}
