package com.benitosaell.movieapi.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benitosaell.movieapi.model.Movie;
import com.benitosaell.movieapi.repository.MoviesRepository;
import com.benitosaell.movieapi.service.IMoviesService;

@Service
public class MoviesService implements IMoviesService {
	@Autowired
	private MoviesRepository repoMovies;
	
	@Override
	public List<Movie> searchAll() {
		return repoMovies.findAll();
	}

	@Override
	public List<Movie> searchAllOrder() {
		return repoMovies.searchAllOrder();
	}

	@Override
	public void save(Movie movie) {
		repoMovies.save(movie);
	}

	@Override
	public void delete(int movie) {
		//repoComments.deleteByMovie(movie);
		repoMovies.deleteById(movie);
	}

	@Override
	public Movie searchMovie(int id) {
		Optional<Movie> optional = repoMovies.findById(id);
		if(optional.isPresent()) {
			Movie movie = optional.get();
			return movie;
		}
		return null;
	}

}
