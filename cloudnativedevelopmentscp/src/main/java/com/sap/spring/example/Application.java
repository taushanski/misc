package com.sap.spring.example;

import com.sap.spring.example.bean.WebShop;
import com.sap.spring.example.config.ApplicationContextConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.getEnvironment().setActiveProfiles("cloud");

			context.register(ApplicationContextConfig.class);
			context.refresh();

			System.out.println("--------------Active Profiles--------------");
			System.out.println(
					"The active profiles are: " + Arrays.toString(context.getEnvironment().getActiveProfiles()));


			System.out.println("--------------Bean Names--------------");
			String[] beanDefinitionNames = context.getBeanDefinitionNames();
			Arrays.stream(beanDefinitionNames).forEach(beanName -> System.out.println("Bean: " + beanName));

			System.out.println("--------------Spring Beans--------------");
			WebShop webShop1 = (WebShop) context.getBean("webShop");
			System.out.println("Spring Bean webShop1: " + webShop1.toString());
			WebShop webShop2 = (WebShop) context.getBean("webShop");
			System.out.println("Spring Bean webShop2: " + webShop2.toString());

  			System.out.println("----------------------------------------");
			System.out.println("Manually creating WebShop instance");
			WebShop webShop3 = new WebShop();
			System.out.println("webShop3: " + webShop3.toString());

			System.out.println("----------------------------------------");
			System.out.println("webShop1.check() Bean: ");
			webShop1.check();
			System.out.println("webShop2.check() Bean: ");
			webShop2.check();
			System.out.println("webShop3.check() Bean: ");
			webShop3.check();
		}
	}
}
