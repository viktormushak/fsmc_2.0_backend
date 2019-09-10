package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Address;
import com.fsmc.backend.data.model.Company;
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
            "SELECT profile.id, user_name, user_surname, email, phone, profile.address_id, region, city, street, build, profile.company_id, company_name FROM user " +
                    "LEFT JOIN (select profile.id, user_id, user_name, user_surname, email, phone, company_id, address_id, region, city, street, build, company_name FROM profile " +
                    "LEFT JOIN (select address.id, region, city, street, build, company_name from address left join company on address.company_id = company.id) as address on profile.address_id = address.id) as profile" +
                    " on user.id = profile.id WHERE username = ?";

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
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("user_name"))
                    .surname(resultSet.getString("user_surname"))
                    .email(resultSet.getString("email"))
                    .phone(resultSet.getString("phone"))
                    .address(Address.builder()
                            .id(resultSet.getInt("address_id"))
                            .region(resultSet.getString("region"))
                            .city(resultSet.getString("city"))
                            .street(resultSet.getString("street"))
                            .build(resultSet.getString("build"))
                            .build())
                    .company(Company.builder()
                            .id(resultSet.getInt("company_id"))
                            .name(resultSet.getString("company_name"))
                            .build())
                    .build();
        }
    }
}
