package com.benitosaell.movieapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.benitosaell.movieapi.model.User;
import com.benitosaell.movieapi.model.UserLogin;
import com.benitosaell.movieapi.service.IUsersService;

@RestController
@RequestMapping("/api/usuarios")
public class UsersController {
	
	@Autowired
	private IUsersService serviceUsers;
	
	@GetMapping("/users")
	private List<User> searchAll(){
		return null;
	}
	
	@PostMapping("/crear")
	private User insertUser(@RequestBody User user) {
		serviceUsers.save(user);
		
		return user;
	}
	
	@PostMapping("/login")
	private User login(@RequestBody UserLogin user) {
		User user2 = serviceUsers.searchUserByUsername(user.getUsername());
		if(user2.getPassword().equals(user.getPassword())) {
			user2.setPassword("");
			return user2;
		}else {
			return null;
		}
		
	}
}
