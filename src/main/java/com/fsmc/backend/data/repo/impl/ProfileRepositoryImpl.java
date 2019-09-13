package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Profile;
import com.fsmc.backend.data.repo.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProfileRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int updateByUsername(Profile profile, String username) {
        String sql = "update user set user_name = ?, user_surname = ?, " +
                "user_patronymic = ?, email = ?, phone = ? where username = ?";
        return jdbcTemplate.update(sql, profile.getName(), profile.getSurname(), profile.getPatronymic(),
                profile.getEmail(), profile.getPhone(), username);
    }

    @Override
    public int attachRawData(String rawName, String username) {
        String sql = "update user left join raw_data on uuid = e_uuid " +
                "set uuid = (select distinct e_uuid from raw_data where r_employee = ?)" +
                " where username = ?";
        return jdbcTemplate.update(sql, rawName, username);
    }
}
