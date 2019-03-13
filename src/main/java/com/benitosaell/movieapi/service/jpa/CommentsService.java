package com.benitosaell.movieapi.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benitosaell.movieapi.model.Comment;
import com.benitosaell.movieapi.repository.CommentsRepository;
import com.benitosaell.movieapi.service.ICommentsService;

@Service
public class CommentsService implements ICommentsService {
	@Autowired 
	private CommentsRepository repoComments;
	
	@Override
	public List<Comment> searchByMovie(int idMovie) {
		return repoComments.findByMovie_IdOrderByDate(idMovie);
	}

	@Override
	public void save(Comment comment) {
		repoComments.save(comment);
	}
}
