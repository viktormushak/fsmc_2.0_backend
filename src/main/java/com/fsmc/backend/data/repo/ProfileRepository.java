package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.Profile;

import java.util.Optional;

public interface ProfileRepository {
    int updateByUsername(Profile profile, String username);

    int attachRawData(String rawName, String rawAddress, String username);

    Profile getWithRawDataByUsername(String username);
}
