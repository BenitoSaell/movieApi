package com.benitosaell.movieapi.service;

import java.util.List;

import com.benitosaell.movieapi.model.Comment;

public interface ICommentsService {
	List<Comment> searchByMovie(int idMovie);
	void save(Comment comment);
	void deleteByMovie(int movie);
}
