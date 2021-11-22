package com.learning.Spring.Microservices.SpringMicroservices.Controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.Spring.Microservices.SpringMicroservices.Bean.User;
import com.learning.Spring.Microservices.SpringMicroservices.Dao.UserDao;
import com.learning.Spring.Microservices.SpringMicroservices.Exception.UserNotFoundException;

@RestController
public class UserController {
	
	@Autowired
	private UserDao dao;
	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return dao.getAllUser();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> getUserById(@PathVariable int id){
		 User userById = dao.getUserById(id);
		 
		 if(userById == null)
			 throw new UserNotFoundException("No USER present with id - "+id);
		 
		 
		 
		 EntityModel<User> resource = EntityModel.of(userById);
		 
		 WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUser());
		 
		 resource.add(linkTo.withRel("all-user"));
		 
		 return resource;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		User saveUser = dao.saveUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id){
		 User userById = dao.deleteUserById(id);
		 
		 if(userById == null)
			 throw new UserNotFoundException("No USER present with id - "+id);
		 
		 return ;
	}
	
}
