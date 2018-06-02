package com.sap.spring.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.sap.spring.example")
@EnableWebMvc
public class SpringConfiguration {
}
