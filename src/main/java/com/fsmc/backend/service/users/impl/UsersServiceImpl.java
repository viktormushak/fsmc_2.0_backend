package com.fsmc.backend.service.users.impl;

import com.fsmc.backend.data.model.User;
import com.fsmc.backend.data.repo.UsersRepository;
import com.fsmc.backend.service.users.UsersService;
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
        user.setEnabled(1);
        return usersRepository.findByUsername(user.getUsername()).isPresent() ? User.EMPTY : usersRepository.save(user);
    }
}
