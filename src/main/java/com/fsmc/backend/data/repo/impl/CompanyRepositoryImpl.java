package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Company;
import com.fsmc.backend.data.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    private final JdbcTemplate jdbcTemplate;
    private static final String GET_COMPANIES_BY_RESPONSIBLE_USERNAME =
            "select company.id, company.company_name from user left join " +
            "(select company.id, company.company_name, company_to_user.user_id from company left join company_to_user on company.id = company_to_user.company_id) as company" +
            " on user.id = company.user_id where username = ?";

    @Autowired
    public CompanyRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Company> getCompaniesByResponsibleUsername(String username) {
        return jdbcTemplate.query(GET_COMPANIES_BY_RESPONSIBLE_USERNAME, new String[]{username}, new CompanyMapper());
    }

    private static class CompanyMapper implements RowMapper<Company> {

        @Override
        public Company mapRow(ResultSet resultSet, int i) throws SQLException {
            return Company.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("company_name"))
                    .build();
        }
    }
}
