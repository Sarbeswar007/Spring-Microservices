package com.learning.Spring.Microservices.SpringMicroservices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learning.Spring.Microservices.SpringMicroservices.Bean.SomeBean;
import com.learning.Spring.Microservices.SpringMicroservices.Bean.SomeOtherBean;
import com.learning.Spring.Microservices.SpringMicroservices.Dao.SomeBeanDao;

@RestController
public class FilteringController {

	@Autowired
	private SomeBeanDao someBeanDao;

	@GetMapping("/filtering")
	public List<SomeBean> getSomeBeans() {
		return someBeanDao.getAllSomeBean();
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue getSomeOtherBeans() {

		List<SomeOtherBean> listBean = someBeanDao.getAllOtherSomeBean();

		SimpleBeanPropertyFilter simpleBeanPropertyFilter = getSimpleBeanPropertyFilter(new String[] {"field1", "field3"});
		
		FilterProvider filter = new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", simpleBeanPropertyFilter);

		MappingJacksonValue mapper = new MappingJacksonValue(listBean);
		mapper.setFilters(filter);
		
		return mapper;
	}
	
	private static SimpleBeanPropertyFilter getSimpleBeanPropertyFilter(String[] fields) {
		SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
		return simpleBeanPropertyFilter;
	}
}
