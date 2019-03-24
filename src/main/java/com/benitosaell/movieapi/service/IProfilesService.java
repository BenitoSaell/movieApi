package com.benitosaell.movieapi.service;

import org.springframework.scheduling.annotation.Async;

import com.benitosaell.movieapi.model.Profile;

public interface IProfilesService {
	@Async("asyncExecutor")
	void save(Profile profile);
}
