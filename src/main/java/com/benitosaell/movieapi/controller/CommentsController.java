package com.benitosaell.movieapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitosaell.movieapi.model.Comment;
import com.benitosaell.movieapi.service.ICommentsService;

@RestController
@RequestMapping("/api/comentarios")
public class CommentsController {
	@Autowired
	private ICommentsService serviceComments;
	
	@GetMapping("/comentarios/{idMovie}")
	private List<Comment> searchComments(@PathVariable("idMovie") int idMovie) {
		return serviceComments.searchByMovie(idMovie);
	}
	
	@PostMapping("/comentario")
	private Comment insertComment(@RequestBody Comment comment) {
		serviceComments.save(comment);
		return comment;
	}

}
