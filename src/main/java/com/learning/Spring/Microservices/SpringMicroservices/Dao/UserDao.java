package com.learning.Spring.Microservices.SpringMicroservices.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.learning.Spring.Microservices.SpringMicroservices.Bean.User;

@Component
public class UserDao {
	
	static List<User> userList = new ArrayList<User>();
	static private int userCount = 3;
	static {
		userList.add(new User(1, "Sarbeswar Basak", new Date("09/03/1997")));
		userList.add(new User(2, "Purnima Basak", new Date("03/03/1969")));
		userList.add(new User(3, "Aloke Kumar Basak", new Date("06/08/1958")));
	}
	
	public List<User> getAllUser(){
		return userList;
	}
	
	public User getUserById(int id){
		Optional<User> user = userList.stream().filter(p -> Integer.valueOf(id).equals(p.getId())).findAny();
		return user.orElse(null);
	}
	
	public User saveUser(User tmpUser){
		if(tmpUser.getId() == 0)
			tmpUser.setId(++userCount);
		userList.add(tmpUser);
		return tmpUser;
	}
	
	public User deleteUserById(int id){
		Optional<User> user = userList.stream().filter(p -> Integer.valueOf(id).equals(p.getId())).findAny();
		if(user.isPresent())
		{
			userList.remove(user.get());
			return user.get();
		}
		return null;
	}
}
