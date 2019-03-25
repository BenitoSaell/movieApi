package com.benitosaell.movieapi.service;

import java.util.List;
import com.benitosaell.movieapi.model.Movie;

public interface IMoviesService {
	List<Movie> searchAll();
	List<Movie> searchAllOrder();
	Movie searchMovie(int id);
	void save(Movie movie);
	void delete(int movie);
	
}
