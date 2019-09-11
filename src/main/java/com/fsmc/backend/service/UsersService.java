package com.fsmc.backend.service;

import com.fsmc.backend.data.model.User;
import com.fsmc.backend.data.model.UserProfile;

public interface UsersService {
    User create(User user);

    UserProfile updateProfile(UserProfile userProfile, String uuid);

    UserProfile getProfileByUuid(String uuid);
}
