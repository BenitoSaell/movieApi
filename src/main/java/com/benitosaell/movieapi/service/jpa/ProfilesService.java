package com.benitosaell.movieapi.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benitosaell.movieapi.model.Profile;
import com.benitosaell.movieapi.repository.ProfilesRepository;
import com.benitosaell.movieapi.service.IProfilesService;

@Service
public class ProfilesService implements IProfilesService{
	@Autowired
	private ProfilesRepository profilesRepo;
	
	@Override
	public void save(Profile profile) {
		profilesRepo.save(profile);
	}

}
