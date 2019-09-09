package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.Profile;
import com.fsmc.backend.data.repo.ProfilesRepository;
import com.fsmc.backend.service.ProfilesService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfilesServiceImpl implements ProfilesService {

    private final ProfilesRepository profilesRepository;

    public ProfilesServiceImpl(ProfilesRepository profilesRepository) {
        this.profilesRepository = profilesRepository;
    }

    @Override
    public Profile getByUsername(String username) {
        Optional<Profile> profile = profilesRepository.getByUsername(username);
        return profile.orElse(Profile.EMPTY);
    }
}
