package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.Profile;
import com.fsmc.backend.data.repo.ProfileRepository;
import com.fsmc.backend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile updateProfileByUsername(Profile profile, String username) {
        return profileRepository.updateByUsername(profile, username) > 0 ? profile : Profile.EMPTY;
    }
}
