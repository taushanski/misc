package com.sap.spring.example.impl;

import com.sap.spring.example.bean.CreditCheck;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Primary
//@Component("creditCheck")

@Profile("local")
@Component
public class CreditCheckImpl implements CreditCheck {

	public CreditCheckImpl() {
		System.out.println("Constructor for" + getClass().getName());
	}

	@Override
	public void check() {
		System.out.println(getClass().getName() + ".check()");
	}
}
