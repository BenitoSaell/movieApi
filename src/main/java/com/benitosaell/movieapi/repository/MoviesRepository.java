package com.benitosaell.movieapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.benitosaell.movieapi.model.Movie;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {
	@Query(value="SELECT * FROM movies ORDER BY releaseDate DESC, title ASC", 
			  nativeQuery = true)
	List<Movie> searchAllOrder();
}
