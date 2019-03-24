package com.benitosaell.movieapi.service;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.benitosaell.movieapi.model.User;
import com.benitosaell.movieapi.model.UserLogin;

public interface IUsersService {
	List<User> searchAll();
	@Async("asyncExecutor")
	void save(User user);
	User searchUserByUsername(String username);
	@Async("asyncExecutor")
	String login(UserLogin user);
}
