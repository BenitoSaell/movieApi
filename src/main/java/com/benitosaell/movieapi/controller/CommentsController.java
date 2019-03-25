package com.benitosaell.movieapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.benitosaell.movieapi.model.Comment;
import com.benitosaell.movieapi.service.ICommentsService;
/*
 * Controlador para funciones de los comentarios si se esta autentificado 
 * 
*/
@RestController
@RequestMapping("/api/comentarios")
public class CommentsController {
	@Autowired
	private ICommentsService serviceComments;
	
	/*
	 * Guardar un nuevo comentario 
	*/
	@PostMapping("/comentario")
	private Comment insertComment(@RequestBody Comment comment) {
		serviceComments.save(comment);
		return comment;
	}

}
