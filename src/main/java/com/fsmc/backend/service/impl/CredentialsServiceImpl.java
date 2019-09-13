package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.Credentials;
import com.fsmc.backend.data.repo.CredentialsRepository;
import com.fsmc.backend.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CredentialsServiceImpl implements CredentialsService {

    private final CredentialsRepository credentialsRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CredentialsServiceImpl(CredentialsRepository credentialsRepository, PasswordEncoder passwordEncoder) {
        this.credentialsRepository = credentialsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Credentials saveNewCredentials(Credentials credentials) {
        Credentials userCredentials = Credentials.builder()
                .username(credentials.getUsername())
                .password(passwordEncoder.encode(credentials.getPassword()))
                .authority("ROLE_USER")
                .enabled(true)
                .build();
        return credentialsRepository.save(userCredentials) > 0 ? userCredentials : Credentials.EMPTY;
    }
}
