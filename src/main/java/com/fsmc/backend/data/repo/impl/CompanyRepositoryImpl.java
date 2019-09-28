package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Company;
import com.fsmc.backend.data.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CompanyRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Company> getAll() {
        return jdbcTemplate.query(
                "SELECT company, last_update FROM companies",
                new CompanyMapper());
    }

    private static class CompanyMapper implements RowMapper<Company> {

        @Override
        public Company mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Company(resultSet.getString("company"), resultSet.getLong("last_update"));
        }
    }
}
