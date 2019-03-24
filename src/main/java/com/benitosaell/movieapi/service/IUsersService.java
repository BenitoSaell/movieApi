package com.benitosaell.movieapi.service;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.benitosaell.movieapi.model.User;

public interface IUsersService {
	List<User> searchAll();
	@Async("asyncExecutor")
	void save(User user);
	User searchUserByUsername(String username);
}
