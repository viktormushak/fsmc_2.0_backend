package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.User;
import com.fsmc.backend.data.model.UserProfile;
import com.fsmc.backend.data.repo.UsersRepository;
import com.fsmc.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usersRepository.save(user).orElse(User.EMPTY);
    }

    @Override
    public UserProfile updateProfile(UserProfile userProfile, String uuid) {
        return usersRepository.updateProfile(userProfile, uuid).orElse(UserProfile.EMPTY);
    }

    @Override
    public UserProfile getProfileByUuid(String uuid) {
        return usersRepository.getProfileByUuid(uuid).orElse(UserProfile.EMPTY);
    }
}
