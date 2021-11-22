package com.learning.Spring.Microservices.SpringMicroservices.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.Spring.Microservices.SpringMicroservices.Bean.Posts;
import com.learning.Spring.Microservices.SpringMicroservices.Bean.User;
import com.learning.Spring.Microservices.SpringMicroservices.Dao.PostRepositoryDao;
import com.learning.Spring.Microservices.SpringMicroservices.Dao.UserRepositoryDao;
import com.learning.Spring.Microservices.SpringMicroservices.Exception.UserNotFoundException;

@RestController
@RequestMapping("/jpa")
public class UserJPAController {

	@Autowired
	private UserRepositoryDao userRepositoryDao;
	
	@Autowired
	private PostRepositoryDao postRepositoryDao;

	@GetMapping("/users")
	public List<User> getAllUser() {
		return userRepositoryDao.findAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> getUserById(@PathVariable int id) {
		Optional<User> findById = userRepositoryDao.findById(id);

		if (!findById.isPresent())
			throw new UserNotFoundException("No USER present with id - " + id);
		User userById = findById.get();

		EntityModel<User> resource = EntityModel.of(userById);

		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUser());

		resource.add(linkTo.withRel("all-user"));

		return resource;
	}

	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
		User saveUser = userRepositoryDao.save(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveUser.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		userRepositoryDao.deleteById(id);

		/*
		 * if(userById == null) throw new
		 * UserNotFoundException("No USER present with id - "+id);
		 */

		return;
	}
	
	
	@GetMapping("/users/{userId}/posts")
	public List<Posts> getAllPostsByUserId(@PathVariable int userId) {
		Optional<User> findById = userRepositoryDao.findById(userId);
		
		if(!findById.isPresent())
			throw new UserNotFoundException("User not found by id- "+userId);
		return findById.get().getPosts();
	}
	
	@PostMapping("/users/{userId}/posts")
	public ResponseEntity<User> savePostForUser(@PathVariable int userId, @RequestBody Posts post) {
		Optional<User> findById = userRepositoryDao.findById(userId);
		
		if(!findById.isPresent())
			throw new UserNotFoundException("User not found by id- "+userId);
		
		post.setUser(findById.get());
		
		Posts savedPost = postRepositoryDao.save(post);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPost.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
}
