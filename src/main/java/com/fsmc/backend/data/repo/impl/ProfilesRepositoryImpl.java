package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Profile;
import com.fsmc.backend.data.repo.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class ProfilesRepositoryImpl implements ProfilesRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ProfileMapper profileMapper;

    private static final String GET_BY_USERNAME_QUERY =
            "SELECT name, surname, email, phone FROM users LEFT JOIN profiles p on users.id = p.user_id WHERE username = ?";

    @Autowired
    public ProfilesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        profileMapper = new ProfileMapper();
    }

    @Override
    public Optional<Profile> getByUsername(String username) {
        Profile profile = jdbcTemplate.queryForObject(GET_BY_USERNAME_QUERY, new String[]{username}, profileMapper);
        return Optional.ofNullable(profile);
    }

    private static class ProfileMapper implements RowMapper<Profile> {

        @Override
        public Profile mapRow(ResultSet resultSet, int i) throws SQLException {
            return !resultSet.first() ? null : Profile.builder()
                    .name(resultSet.getString("name"))
                    .surname(resultSet.getString("surname"))
                    .email(resultSet.getString("email"))
                    .phone(resultSet.getString("phone"))
                    .build();
        }
    }
}
