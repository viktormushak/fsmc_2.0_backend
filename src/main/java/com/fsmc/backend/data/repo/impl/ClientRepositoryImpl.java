package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.ClientDetails;
import com.fsmc.backend.data.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> getAllByCompany(String company) {
        return jdbcTemplate.query(
                "SELECT DISTINCT e_uuid, r_employee, company_name, r_address, SUM(quantity) AS quantity FROM raw_data WHERE company_name=? GROUP BY r_employee ORDER BY quantity DESC",
                new String[]{company},
                new ClientMapper());
    }

    @Override
    public ClientDetails getClientDetailsById(Integer clientId) {
        ClientDetails details = jdbcTemplate.queryForObject(
                "SELECT DISTINCT r_employee, SUM(quantity) AS quantity FROM raw_data WHERE e_uuid=?",
                new String[]{String.valueOf(clientId)},
                new ClientDetailsMapper());
        Objects.requireNonNull(details).setAddresses(jdbcTemplate.query(
                "SELECT DISTINCT r_address FROM raw_data WHERE e_uuid=?",
                new String[]{String.valueOf(clientId)},
                new ClientDetailsAddressMapper()));
        Objects.requireNonNull(details).setBrands(jdbcTemplate.query(
                "SELECT DISTINCT r_sale, SUM(quantity) AS quantity FROM raw_data WHERE e_uuid=? GROUP BY r_sale",
                new String[]{String.valueOf(clientId)},
                new ClientDetailsBrandMapper()));
        return details;
    }

    private static class ClientMapper implements RowMapper<Client> {

        @Override
        public Client mapRow(ResultSet resultSet, int i) throws SQLException {
            return Client.builder()
                    .hashId(resultSet.getInt("e_uuid"))
                    .name(resultSet.getString("r_employee"))
                    .company(resultSet.getString("company_name"))
                    .address(resultSet.getString("r_address"))
                    .totalScore(resultSet.getDouble("quantity"))
                    .build();
        }
    }

    private static class ClientDetailsMapper implements RowMapper<ClientDetails> {

        @Override
        public ClientDetails mapRow(ResultSet resultSet, int i) throws SQLException {
            return ClientDetails.builder()
                    .name(resultSet.getString("r_employee"))
                    .totalScore(resultSet.getDouble("quantity"))
                    .build();
        }
    }

    private static class ClientDetailsAddressMapper implements RowMapper<ClientDetails.Address> {

        @Override
        public ClientDetails.Address mapRow(ResultSet resultSet, int i) throws SQLException {
            return ClientDetails.Address.builder().address(resultSet.getString("r_address")).build();
        }
    }

    private static class ClientDetailsBrandMapper implements RowMapper<ClientDetails.Brand> {

        @Override
        public ClientDetails.Brand mapRow(ResultSet resultSet, int i) throws SQLException {
            return new ClientDetails.Brand(resultSet.getString("r_sale"), resultSet.getDouble("quantity"));
        }
    }
}
