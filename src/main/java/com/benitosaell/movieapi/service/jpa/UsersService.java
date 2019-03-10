package com.benitosaell.movieapi.service.jpa;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benitosaell.movieapi.model.User;
import com.benitosaell.movieapi.repository.UsersRepository;
import com.benitosaell.movieapi.service.IUsersService;
@Service
public class UsersService implements IUsersService {
	@Autowired
	private UsersRepository repoUsers;
	@Override
	public List<User> searchAll() {
		return repoUsers.findAll();
	}

	@Override
	public void save(User user) {
		repoUsers.save(user);
	}

}
