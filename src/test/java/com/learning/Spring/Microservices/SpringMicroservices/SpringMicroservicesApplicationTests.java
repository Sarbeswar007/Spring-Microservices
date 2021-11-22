package com.learning.Spring.Microservices.SpringMicroservices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringMicroservicesApplicationTests {

	private static Logger log = LoggerFactory.getLogger(SpringMicroservicesApplicationTests.class);
	
	@Test
	void contextLoads() {
		log.info("Test Case executing");
		log.info("Test Case executing for the second time....!!!!!!");
		assertEquals(1, 1);
	}

}
