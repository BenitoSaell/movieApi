package com.benitosaell.movieapi.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private IMoviesService serviceMovies;
	
	@Autowired
	private ICommentsService serviceComments;
	
	@Autowired
	private IUsersService serviceUsers;
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//@Resource(name = "authenticationManager")
	//private AuthenticationManager authManager;
	
	@GetMapping("/peliculas")
	private List<Movie> searchAllOrder(){
		return serviceMovies.searchAllOrder();
	}
	
	@GetMapping("/ver/{id}")
	private Movie searchMovie(@PathVariable("id") int id){
		return serviceMovies.searchMovie(id);
	}
	
	@GetMapping("/comentarios/{idMovie}")
	private List<Comment> searchComments(@PathVariable("idMovie") int idMovie) {
		return serviceComments.searchByMovie(idMovie);
	}
	
	@PostMapping("/crear")
	private User insertUser(@RequestBody User user) {
		serviceUsers.save(user);

		return user;
	}
	
	/*@PostMapping("/login")
	private SecurityContext login(@RequestBody UserLogin user, HttpServletRequest req) {
		/UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(user.getUsername(),
				bCryptPasswordEncoder.encode(user.getPassword()));
		Authentication auth = authManager.authenticate(authReq);
		SecurityContext sc = SecurityContextHolder.getContext();
		sc.setAuthentication(auth);
		// HttpSession session = req.getSession(true);
		return sc;
	}*/
}
