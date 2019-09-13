package com.fsmc.backend.service;

import com.fsmc.backend.data.model.Profile;

public interface ProfileService {

    Profile updateProfileByUsername(Profile profile, String username);
}
