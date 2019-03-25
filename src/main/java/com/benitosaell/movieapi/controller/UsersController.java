package com.benitosaell.movieapi.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.benitosaell.movieapi.model.User;
import com.benitosaell.movieapi.service.IUsersService;

/*
 * Controlador para operaciones sobre usuarios.
*/
@RestController
@RequestMapping("/api/usuarios")
public class UsersController {

	@Autowired
	private IUsersService serviceUsers;

	/*
	 * Obtener la lista de usuarios. (No implementada)
	*/
	@GetMapping("/users")
	private List<User> searchAll() {
		return serviceUsers.searchAll();
	}	
}
	
