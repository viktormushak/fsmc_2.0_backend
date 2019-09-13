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

    @Override
    public Profile getWithRawDataByUsername(String username) {
        String sql = "select distinct uuid, user_name, user_surname, user_patronymic, email, phone, r_employee, r_address from user " +
                "left join raw_data on uuid = e_uuid where username = ?";
        return jdbcTemplate.queryForObject(sql, new String[]{username}, (rs, rowNum) -> Profile.builder()
                .uuid(rs.getInt("uuid"))
                .rawData(rs.getString("r_employee"))
                .name(rs.getString("user_name"))
                .surname(rs.getString("user_surname"))
                .patronymic(rs.getString("user_patronymic"))
                .email(rs.getString("email"))
                .phone(rs.getString("phone"))
                .build());
    }
}
