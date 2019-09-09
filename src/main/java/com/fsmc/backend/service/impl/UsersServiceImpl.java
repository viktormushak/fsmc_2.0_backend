package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.User;
import com.fsmc.backend.data.repo.UsersRepository;
import com.fsmc.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User createUser(User user) {
        user.setAuthority("ROLE_USER");
        user.setEnabled(true);
        return usersRepository.findByUsername(user.getUsername()).isPresent() ? User.EMPTY : usersRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String username) {
        return usersRepository.findByUsername(username).orElse(User.EMPTY);
    }
}
