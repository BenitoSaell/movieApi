package com.benitosaell.movieapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitosaell.movieapi.model.Movie;
import com.benitosaell.movieapi.service.IMoviesService;

/*
 * Obtener la lista de peliculas ordenadas
*/
@RestController
@RequestMapping("/api/peliculas")
public class MoviesController {
	@Autowired
	private IMoviesService serviceMovies;
	
	/*
	 * Obtener la lista de peliculas almacenadas en la base de datos.
	*/
	@GetMapping("/peliculas")
	private List<Movie> searchAll(){
		return serviceMovies.searchAll();
	}
	
	/*
	 * Obtener la información de una pelicula.
	*/
	@GetMapping("/ver/{id}")
	private Movie searchMovie(@PathVariable("id") int id){
		return serviceMovies.searchMovie(id);
	}
	
	
	/*
	 * Registrar una nueva pelicula o actualizar su información.
	*/
	@PostMapping("/crear")
	private Movie insertMovie(@RequestBody Movie movie) {
		serviceMovies.save(movie);
		return movie;
	}
	
	/*
	 * Eliminar una pelicula con sus comentarios de la base de datos.
	*/
	@GetMapping(path="/eliminar/{id}")
	private void deleteMovie(@PathVariable("id") int id) {
		serviceMovies.delete(id);		
	}
}
