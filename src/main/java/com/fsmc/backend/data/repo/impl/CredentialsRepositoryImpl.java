package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Credentials;
import com.fsmc.backend.data.repo.CredentialsRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CredentialsRepositoryImpl implements CredentialsRepository {

    private final JdbcTemplate jdbcTemplate;

    public CredentialsRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Credentials credentials) {
        String sql = "INSERT INTO user (username, password, authority, enabled) values (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, credentials.getUsername(), credentials.getPassword(),
                credentials.getAuthority(), credentials.isEnabled());
    }
}
