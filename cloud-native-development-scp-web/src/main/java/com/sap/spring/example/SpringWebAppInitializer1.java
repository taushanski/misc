package com.sap.spring.example;

import com.sap.spring.example.config.SpringConfiguration;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import static com.sap.spring.example.Constants.DISPATCHER_SERVLET_URL_MAPPING;
import static com.sap.spring.example.Constants.LOAD_ON_STARTUP;

public class SpringWebAppInitializer1
		//		implements WebApplicationInitializer
{


//	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Create the 'root' Spring application context
		WebApplicationContext rootContext = getApplicationContext();

		registerDispatcherServlet(servletContext, rootContext);

		// Manage the lifecycle of the root application context
		servletContext.addListener(new ContextLoaderListener(rootContext));
	}

	private void registerDispatcherServlet(ServletContext servletContext, WebApplicationContext rootContext) {
		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
																		   new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(LOAD_ON_STARTUP);
		dispatcher.addMapping(DISPATCHER_SERVLET_URL_MAPPING);
	}

	private WebApplicationContext getApplicationContext() {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SpringConfiguration.class);
		return rootContext;
	}
}
