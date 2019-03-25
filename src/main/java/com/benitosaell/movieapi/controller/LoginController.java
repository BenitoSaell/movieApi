package com.benitosaell.movieapi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitosaell.movieapi.model.User;
import com.benitosaell.movieapi.service.IUsersService;

@RestController
@RequestMapping("/api/admin")
public class LoginController {
	@Autowired
	private IUsersService serviceUsers;
	
	@GetMapping("/user")
	private User logout(Authentication auth) {
		try {
			System.out.println("username:  "+auth.getName());
			User user=serviceUsers.searchUserByUsername(auth.getName());
			user.setPassword("");
			return user;
		} catch (Exception ex) {
			System.out.println("ErrorUser: "+ ex);
			return null;
		}
	}
	
	@GetMapping("/salir")
	private boolean logout(HttpServletRequest request) {
		try {
			SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
			logoutHandler.logout(request, null, null);

			return true;
		} catch (Exception ex) {
			System.out.println("ErrorSalir: "+ ex);
			return false;
		}
	}
}
