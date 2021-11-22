package com.learning.Spring.Microservices.SpringMicroservices;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Sarbeswar Basak", "basak.com",
			"sarbeswarbasak@gmail.com");
	public static final ApiInfo DEFAULT = new ApiInfo("Awesome Api Title", "Awesome Api Documentation", "1.0",
			"urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>());
	private static final Set<String> producerAndConsumer = new HashSet<>();
	static {
		producerAndConsumer.add("application/json");
		producerAndConsumer.add("application/xml");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT).produces(producerAndConsumer)
				.consumes(producerAndConsumer);
	}
}
