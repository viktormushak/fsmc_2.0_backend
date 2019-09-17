package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> getAllByCompany(String company) {
        return jdbcTemplate.query(
                "SELECT DISTINCT e_uuid, r_employee, company_name, r_address, SUM(quantity) as quantity" +
                        " from raw_data group by r_employee order by quantity DESC",
                new ClientMapper());
    }

    private static class ClientMapper implements RowMapper<Client> {

        @Override
        public Client mapRow(ResultSet resultSet, int i) throws SQLException {
            return Client.builder()
                    .uuid(resultSet.getInt("e_uuid"))
                    .name(resultSet.getString("r_employee"))
                    .companyName(resultSet.getString("company_name"))
                    .address(resultSet.getString("r_address"))
                    .score(resultSet.getDouble("quantity"))
                    .build();
        }
    }
}
