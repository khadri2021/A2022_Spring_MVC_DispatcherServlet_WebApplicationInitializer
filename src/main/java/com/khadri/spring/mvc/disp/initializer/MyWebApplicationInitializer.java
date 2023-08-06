package com.khadri.spring.mvc.disp.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Component
public class MyWebApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	 
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setConfigLocation("/WEB-INF/dispatcher-config.xml");
		
		ServletRegistration.Dynamic registration = servletContext.addServlet("disp", new DispatcherServlet(context));
		
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
		
	}

}
