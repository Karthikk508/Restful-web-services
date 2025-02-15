package com.karthik.rest.webservices.restful_web_services.user;


import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	
	private MessageSource messageSource;
	private UserDaoService service;
	
	public UserResource(UserDaoService service,MessageSource messageSource) {
		this.service = service;
		this.messageSource = messageSource;
	}
	
	
	@GetMapping("/users")
	public List<User> retreiveAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable int id)
	{
		User user = service.findById(id);
		
		if(user == null) {
			throw new UserNotFoundException("id:" + id);
		}
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		
		User savedUser = service.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				                                  .path("/{id}")
				                                  .buildAndExpand(savedUser.getId())
				                                  .toUri();
		
		return ResponseEntity.created(location).build();
	}
	

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized() {
		
		Locale locale = LocaleContextHolder.getLocale();		
		return messageSource.getMessage("good.morning.message", null, "Default message", locale);
		
		
		//return "Hello world v2";
				
				
	}
	

}
