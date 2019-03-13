package com.benitosaell.movieapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/user/{email}")
	private User searchUser(@PathVariable("email") String email){
		return null;
	}
	
	@PostMapping("/crear")
	private User insertUser(@RequestBody User user) {
		System.out.println("UserApi: "+user);
		serviceUsers.save(user);
		
		//Profile profile = new Profile();
		//profile.setEmail(user.getEmail());
		//profile.setProfile("User");
		//serviceProfiles.save(profile);

		
		return user;
	}
	
	@PostMapping("/login")
	private UserLogin login(@RequestBody UserLogin user) {
		
		User user2 = serviceUsers.searchUserByUsername(user.getUsername());
		System.out.println("UserApi: "+user+"  "+user2);
		if(user2.getPassword().equals(user.getPassword())) {
			return user;
		}else {
			return null;
		}
		
	}
}
