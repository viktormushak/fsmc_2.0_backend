package com.fsmc.backend.service;

import com.fsmc.backend.data.model.Profile;

public interface ProfilesService {
    Profile getByUsername(String username);
}
