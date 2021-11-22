package com.learning.Spring.Microservices.SpringMicroservices.Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learning.Spring.Microservices.SpringMicroservices.Bean.HelloWorldBean;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource; 
	
	@RequestMapping(path="/hello-world", method=RequestMethod.GET)
	public String getHelloWorld() {
		return "Hello World";
	}
	
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean getHelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/hello-world-bean-list")
	public List<HelloWorldBean> getHelloWorldBeanList() {
		List<HelloWorldBean> l = new LinkedList<HelloWorldBean>();
		HelloWorldBean h1 = new HelloWorldBean("Hello World");
		HelloWorldBean h2 = new HelloWorldBean("Hey Buddy");
		HelloWorldBean h3 = new HelloWorldBean("Welcome to the family");
		l.add(h1);l.add(h2);l.add(h3);
		return l;
	}
	
	@GetMapping("/hello-world-variable/{myVariable}")
	public HelloWorldBean getHelloWorldBeanVariable(@PathVariable String myVariable) {
		return new HelloWorldBean("Hello World, "+myVariable);
	}
	
	
	@GetMapping("/hello-world-internationalization")
	public String getHelloWorldInternationalizationBean(@RequestHeader(name="Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	@GetMapping("/hello-world-internationalizationV2")
	public String getHelloWorldInternationalizationBeanV2() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
