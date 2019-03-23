package com.benitosaell.movieapi.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitosaell.movieapi.model.Comment;
import com.benitosaell.movieapi.model.Movie;
import com.benitosaell.movieapi.model.User;
import com.benitosaell.movieapi.model.UserLogin;
import com.benitosaell.movieapi.service.ICommentsService;
import com.benitosaell.movieapi.service.IMoviesService;
import com.benitosaell.movieapi.service.IUsersService;

@RestController
@RequestMapping("/api/publico")
public class PublicController {

	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private IMoviesService serviceMovies;

	@Autowired
	private ICommentsService serviceComments;

	@Autowired
	private IUsersService serviceUsers;

	//BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/peliculas")
	private List<Movie> searchAllOrder() {
		return serviceMovies.searchAllOrder();
	}

	@GetMapping("/ver/{id}")
	private Movie searchMovie(@PathVariable("id") int id) {
		return serviceMovies.searchMovie(id);
	}

	@GetMapping("/comentarios/{idMovie}")
	private List<Comment> searchComments(@PathVariable("idMovie") int idMovie) {
		return serviceComments.searchByMovie(idMovie);
	}

	@PostMapping("/crear")
	private User insertUser(@RequestBody User user) {
		//String temp = bCryptPasswordEncoder.encode(user.getPassword());
		//user.setPassword(temp);
		serviceUsers.save(user);
		return user;
	}	
	
	@PostMapping("/ingresar")
	private String ingresar(@RequestBody UserLogin user) {
		//System.out.println("ffffffff");
		UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(user.getUsername(),
				  bCryptPasswordEncoder.encode(user.getPassword()));
		//System.out.println("Data" + user+ "  : "+authReq);
		return "resultado";

	}
}
