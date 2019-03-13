package com.benitosaell.movieapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.benitosaell.movieapi.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
