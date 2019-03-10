package com.benitosaell.movieapi.service;

import java.util.List;

import com.benitosaell.movieapi.model.User;

public interface IUsersService {
	List<User> searchAll();
	void save(User user);
}
