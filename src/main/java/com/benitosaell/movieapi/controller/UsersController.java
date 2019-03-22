package com.benitosaell.movieapi.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
	private List<User> searchAll() {
		return null;
	}	
}
	
