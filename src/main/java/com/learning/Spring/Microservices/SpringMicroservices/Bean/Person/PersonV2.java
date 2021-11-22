package com.learning.Spring.Microservices.SpringMicroservices.Bean.Person;

public class PersonV2 {

	private FullName fullName;

	public PersonV2() {
		super();
	}

	public PersonV2(FullName fullName) {
		super();
		this.fullName = fullName;
	}

	public FullName getName() {
		return fullName;
	}

	public void setName(FullName fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "PersonV1 [name=" + fullName + "]";
	}
	
}
