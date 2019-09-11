package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.User;
import com.fsmc.backend.data.model.UserProfile;

import java.util.Optional;

public interface UsersRepository {

    Optional<User> save(User user);

    Optional<UserProfile> updateProfile(UserProfile userProfile, String uuid);

    Optional<UserProfile> getProfileByUuid(String uuid);
}
