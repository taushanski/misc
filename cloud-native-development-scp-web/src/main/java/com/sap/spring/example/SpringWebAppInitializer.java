package com.sap.spring.example;

import com.sap.spring.example.config.SpringConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import static com.sap.spring.example.Constants.DISPATCHER_SERVLET_URL_MAPPING;

public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{SpringConfiguration.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{DISPATCHER_SERVLET_URL_MAPPING};
	}
}
