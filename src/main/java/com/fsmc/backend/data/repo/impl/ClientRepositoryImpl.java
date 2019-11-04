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

    @Override
    public List<Client> getAll() {
        return jdbcTemplate.query(
                "SELECT DISTINCT person_id, person, company, address, SUM(quantity) AS quantity FROM raw_data WHERE brand <> '' GROUP BY person ORDER BY quantity DESC",
                new String[]{},
                new ClientMapper());
    }

    public List<Client> getAllByCompany(String company) {
        return jdbcTemplate.query(
                "SELECT DISTINCT person_id, person, company, address, SUM(quantity) AS quantity FROM raw_data WHERE company=? AND brand <> '' GROUP BY person ORDER BY quantity DESC",
                new String[]{company},
                new ClientMapper());
    }

    @Override
    public ClientDetails getClientDetailsById(Integer clientId) {
        ClientDetails details = jdbcTemplate.queryForObject(
                "SELECT DISTINCT person, SUM(quantity) AS quantity FROM raw_data WHERE person_id=? AND brand <> ''",
                new String[]{String.valueOf(clientId)},
                new ClientDetailsMapper());
        Objects.requireNonNull(details).setAddresses(jdbcTemplate.query(
                "SELECT DISTINCT address FROM raw_data WHERE person_id=?",
                new String[]{String.valueOf(clientId)},
                new ClientDetailsAddressMapper()));
        Objects.requireNonNull(details).setBrands(jdbcTemplate.query(
                "SELECT DISTINCT brand, SUM(quantity) AS quantity FROM raw_data WHERE person_id=? AND brand <> '' GROUP BY brand",
                new String[]{String.valueOf(clientId)},
                new ClientDetailsBrandMapper()));
        return details;
    }

    private static class ClientMapper implements RowMapper<Client> {

        @Override
        public Client mapRow(ResultSet resultSet, int i) throws SQLException {
            return Client.builder()
                    .hashId(resultSet.getInt("person_id"))
                    .name(resultSet.getString("person"))
                    .company(resultSet.getString("company"))
                    .address(resultSet.getString("address"))
                    .totalScore(resultSet.getDouble("quantity"))
                    .build();
        }
    }

    private static class ClientDetailsMapper implements RowMapper<ClientDetails> {

        @Override
        public ClientDetails mapRow(ResultSet resultSet, int i) throws SQLException {
            return ClientDetails.builder()
                    .name(resultSet.getString("person"))
                    .totalScore(resultSet.getDouble("quantity"))
                    .build();
        }
    }

    private static class ClientDetailsAddressMapper implements RowMapper<ClientDetails.Address> {

        @Override
        public ClientDetails.Address mapRow(ResultSet resultSet, int i) throws SQLException {
            return ClientDetails.Address.builder().address(resultSet.getString("address")).build();
        }
    }

    private static class ClientDetailsBrandMapper implements RowMapper<ClientDetails.Brand> {

        @Override
        public ClientDetails.Brand mapRow(ResultSet resultSet, int i) throws SQLException {
            return new ClientDetails.Brand(resultSet.getString("brand"), resultSet.getDouble("quantity"));
        }
    }
}
