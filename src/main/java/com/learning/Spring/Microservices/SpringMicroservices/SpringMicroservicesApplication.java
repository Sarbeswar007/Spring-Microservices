package com.learning.Spring.Microservices.SpringMicroservices;

import java.util.Locale;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class SpringMicroservicesApplication {

	private static Logger log = LoggerFactory.getLogger(SpringMicroservicesApplication.class);
	
	@PostConstruct
	public void init() {
		log.info("Application started sucessfully");
	}
	
	public static void main(String[] args) {
		log.info("Inside the main method");
		SpringApplication.run(SpringMicroservicesApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	/*@Bean
	public ResourceBundleMessageSource bundleMessageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource  = new ResourceBundleMessageSource ();
		resourceBundleMessageSource.setBasename("messages");
		
		return resourceBundleMessageSource; 
	}*/

}
