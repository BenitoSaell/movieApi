package com.benitosaell.movieapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitosaell.movieapi.model.Movie;
import com.benitosaell.movieapi.service.IMoviesService;

@RestController
@RequestMapping("/api/peliculas")
public class MoviesController {
	@Autowired
	private IMoviesService serviceMovies;
	
	@GetMapping("/peliculas")
	private List<Movie> searchAll(){
		return serviceMovies.searchAll();
	}
	
	@GetMapping("/peliculas2")
	private List<Movie> searchAllOrder(){
		return serviceMovies.searchAllOrder();
	}
	
	@GetMapping("/ver/{id}")
	private Movie searchMovie(@PathVariable("id") int id){
		return serviceMovies.searchMovie(id);
	}
	
	@PostMapping("/crear")
	private Movie insertMovie(@RequestBody Movie movie) {
		System.out.println("peli Api: "+movie);
		serviceMovies.save(movie);
		return movie;
	}
	
	@PutMapping("/actualizar")
	private Movie updateMovie(@RequestBody Movie movie) {
		serviceMovies.save(movie);
		return movie;
	}
	
	@DeleteMapping("/eliminar/{id}")
	private String deleteMovie(@PathVariable("id") int id) {
		System.out.println("EliminarID: "+id);
		serviceMovies.delete(id);
		
		return "Registro eliminado";
	}
}
