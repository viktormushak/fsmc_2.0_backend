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
                "SELECT company_name as name, last_update, " +
                        " COUNT(DISTINCT e_uuid) as employees," +
                        " SUM(quantity) as score FROM raw_data" +
                        " left join (SELECT company, MAX(last_update) FROM last_company_update GROUP BY company) AS last_company_update" +
                        " on raw_data.company_name = last_company_update.company" +
                        " group by company",
                new CompanyMapper());
    }

    private static class CompanyMapper implements RowMapper<Company> {

        @Override
        public Company mapRow(ResultSet resultSet, int i) throws SQLException {
            return Company.builder()
                    .name(resultSet.getString("name"))
                    .lastUpdate(resultSet.getLong("last_update"))
                    .employees(resultSet.getInt("employees"))
                    .score(resultSet.getInt("score"))
                    .build();
        }
    }
}
