package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Company;
import com.fsmc.backend.data.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public CompanyRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Company> getAll() {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        return jdbcTemplate.query("SELECT company_name as name, " +
                        "COUNT(DISTINCT company_name, city, street, building) as addresses, " +
                        "COUNT(DISTINCT employ_id) as employees FROM address group by company_name",
                parameterSource, new CompanyMapper());
    }

    private static class CompanyMapper implements RowMapper<Company> {

        @Override
        public Company mapRow(ResultSet resultSet, int i) throws SQLException {
            return Company.builder()
                    .name(resultSet.getString("name"))
                    .addresses(resultSet.getInt("addresses"))
                    .employees(resultSet.getInt("employees"))
                    .build();
        }
    }
}
