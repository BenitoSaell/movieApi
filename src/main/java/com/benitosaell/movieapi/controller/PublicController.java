package com.benitosaell.movieapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitosaell.movieapi.model.Comment;
import com.benitosaell.movieapi.model.Movie;
import com.benitosaell.movieapi.model.Profile;
import com.benitosaell.movieapi.model.User;
import com.benitosaell.movieapi.model.UserLogin;
import com.benitosaell.movieapi.service.ICommentsService;
import com.benitosaell.movieapi.service.IMoviesService;
import com.benitosaell.movieapi.service.IProfilesService;
import com.benitosaell.movieapi.service.IUsersService;

@RestController
@RequestMapping("/api/publico")
public class PublicController {
	
	@Autowired
	private IMoviesService serviceMovies;

	@Autowired
	private ICommentsService serviceComments;

	@Autowired
	private IUsersService serviceUsers;
	
	@Autowired
	private IProfilesService serviceProfiles;

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
		BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
		String temp = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(temp);
		serviceUsers.save(user);
		Profile profile = new Profile();
		profile.setRol("USER");
		profile.setUsername(user.getUsername());
		serviceProfiles.save(profile);
		return user;
		
	}
}
