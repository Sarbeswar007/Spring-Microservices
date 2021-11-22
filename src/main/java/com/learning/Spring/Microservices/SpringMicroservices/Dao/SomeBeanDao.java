package com.learning.Spring.Microservices.SpringMicroservices.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.Spring.Microservices.SpringMicroservices.Bean.SomeBean;
import com.learning.Spring.Microservices.SpringMicroservices.Bean.SomeOtherBean;

@Component
public class SomeBeanDao {
	
	static List<SomeBean> someBeanList = new ArrayList<SomeBean>();
	static List<SomeOtherBean> someOtherBeanList = new ArrayList<SomeOtherBean>();
	static {
		someBeanList.add(new SomeBean("Bean1-Field1", "Bean1-Field2", "Bean1-Field3"));
		someBeanList.add(new SomeBean("Bean2-Field1", "Bean2-Field2", "Bean2-Field3"));
		someBeanList.add(new SomeBean("Bean3-Field1", "Bean3-Field2", "Bean3-Field3"));
		
		someOtherBeanList.add(new SomeOtherBean("OtherBean1-Field1", "OtherBean1-Field2", "OtherBean1-Field3"));
		someOtherBeanList.add(new SomeOtherBean("OtherBean2-Field1", "OtherBean2-Field2", "OtherBean2-Field3"));
		someOtherBeanList.add(new SomeOtherBean("OtherBean3-Field1", "OtherBean3-Field2", "OtherBean3-Field3"));
	}
	
	public List<SomeBean> getAllSomeBean(){
		return SomeBeanDao.someBeanList;
	}
	
	
	public List<SomeOtherBean> getAllOtherSomeBean(){
		return SomeBeanDao.someOtherBeanList;
	}
	
}
