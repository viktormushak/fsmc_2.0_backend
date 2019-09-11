package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.User;
import com.fsmc.backend.data.model.UserProfile;
import com.fsmc.backend.data.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UsersRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Optional<User> save(User user) {
        try{
            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("uuid", user.getUuid());
            parameterSource.addValue("password", user.getPassword());
            parameterSource.addValue("authority", "ROLE_USER");
            parameterSource.addValue("enabled", 1);
            jdbcTemplate.update(
                    "INSERT INTO user (uuid, password, authority, enabled) values (:uuid, :password, :authority, :enabled)", parameterSource);
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            "SELECT uuid, password, authority, enabled FROM user WHERE uuid = :uuid", parameterSource, new UserMapper()));
        } catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }

    }

    @Override
    public Optional<UserProfile> updateProfile(UserProfile userProfile, String uuid) {
        try{
            MapSqlParameterSource parameterSource = new MapSqlParameterSource();
            parameterSource.addValue("name", userProfile.getName());
            parameterSource.addValue("surname", userProfile.getSurname());
            parameterSource.addValue("patronymic", userProfile.getPatronymic());
            parameterSource.addValue("email", userProfile.getEmail());
            parameterSource.addValue("phone", userProfile.getPhone());
            parameterSource.addValue("uuid", uuid);
            jdbcTemplate.update(
                    "UPDATE user SET user_name = :name, user_surname = :surname, user_patronymic = :patronymic, email = :email,  phone = :phone" +
                            " WHERE uuid = :uuid", parameterSource);
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            "SELECT user_name, user_surname, user_patronymic, email, phone FROM user WHERE uuid = :uuid",
                            parameterSource, new UserProfileMapper()));
        } catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserProfile> getProfileByUuid(String uuid) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("uuid", uuid);
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "SELECT user_name, user_surname, user_patronymic, email, phone FROM user WHERE uuid = :uuid", parameterSource, new UserProfileMapper()));
    }

    static class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return User.builder()
                    .uuid(rs.getString("uuid"))
                    .password(rs.getString("password"))
                    .authority(rs.getString("authority"))
                    .enabled(rs.getBoolean("enabled"))
                    .build();
        }
    }

    static class UserProfileMapper implements RowMapper<UserProfile> {
        @Override
        public UserProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
            return UserProfile.builder()
                    .name(rs.getString("user_name"))
                    .surname(rs.getString("user_surname"))
                    .patronymic(rs.getString("user_patronymic"))
                    .email(rs.getString("email"))
                    .phone(rs.getString("phone"))
                    .build();
        }
    }
}
