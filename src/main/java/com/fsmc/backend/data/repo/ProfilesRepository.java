package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.Profile;

import java.util.Optional;

public interface ProfilesRepository {
    Optional<Profile> getByUsername(String username);
}
