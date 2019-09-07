package com.fsmc.backend.service.users;

import com.fsmc.backend.data.model.User;

public interface UsersService {
    User createUser(User user);

    User loadUserByUsername(String username);
}
