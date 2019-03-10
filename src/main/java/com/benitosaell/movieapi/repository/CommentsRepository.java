package com.benitosaell.movieapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benitosaell.movieapi.model.Comment;
@Repository
public interface CommentsRepository extends JpaRepository<Comment, Integer> {
	List<Comment> findByMovie_IdOrderByDate(int idMovie);
}
