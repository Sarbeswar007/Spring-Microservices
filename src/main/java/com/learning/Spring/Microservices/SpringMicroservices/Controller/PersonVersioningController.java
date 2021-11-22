package com.learning.Spring.Microservices.SpringMicroservices.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.Spring.Microservices.SpringMicroservices.Bean.Person.FullName;
import com.learning.Spring.Microservices.SpringMicroservices.Bean.Person.PersonV1;
import com.learning.Spring.Microservices.SpringMicroservices.Bean.Person.PersonV2;

@RestController
public class PersonVersioningController {

	/*
	 * Option 1: To use different URI's
	 */
	@GetMapping("/v1/Person")
	public PersonV1 getPersonV1() {
		PersonV1 personV1 = new PersonV1("Sarbeswar Basak");
		return personV1;
	}
	
	@GetMapping("/v2/Person")
	public PersonV2 getPersonV2() {
		FullName fullName = new FullName("Sarbeswar", "Basak");
		PersonV2 personV2 = new PersonV2(fullName);
		return personV2;
	}
	
	/*
	 * Option 2: To use different params
	 */
	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 getPersonParamV1() {
		PersonV1 personV1 = new PersonV1("Sarbeswar Basak");
		return personV1;
	}
	
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 getPersonParamV2() {
		FullName fullName = new FullName("Sarbeswar", "Basak");
		PersonV2 personV2 = new PersonV2(fullName);
		return personV2;
	}
	
	
	/*
	 * Option 3: To use different header request value
	 */
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public PersonV1 getPersonHeaderV1() {
		PersonV1 personV1 = new PersonV1("Sarbeswar Basak");
		return personV1;
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public PersonV2 getPersonHeaderV2() {
		FullName fullName = new FullName("Sarbeswar", "Basak");
		PersonV2 personV2 = new PersonV2(fullName);
		return personV2;
	}
	
	
	/*
	 * Option 4: To use different header accept value
	 */
	@GetMapping(value="/person/produces", produces="application/person.v1+json")
	public PersonV1 getPersonProducesV1() {
		PersonV1 personV1 = new PersonV1("Sarbeswar Basak");
		return personV1;
	}
	
	@GetMapping(value="/person/produces", produces="application/person.v2+json")
	public PersonV2 getPersonProducesV2() {
		FullName fullName = new FullName("Sarbeswar", "Basak");
		PersonV2 personV2 = new PersonV2(fullName);
		return personV2;
	}
	
}
