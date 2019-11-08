package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Address;
import com.fsmc.backend.data.model.Brand;
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
                "SELECT * FROM " +
                        "(SELECT DISTINCT company, address_id, address, person_id, person, SUM(quantity) AS quantity FROM raw_data WHERE brand <> '' GROUP BY person) as raw_data " +
                        "LEFT JOIN clients_data ON raw_data.person_id = clients_data.hash_id LEFT JOIN clients_address ON raw_data.address_id = clients_address.hash_id ORDER BY quantity DESC",
                new String[]{},
                new ClientMapper());
    }

    public List<Client> getAllByCompany(String company) {
        return jdbcTemplate.query(
                "SELECT * FROM " +
                        "(SELECT DISTINCT company, address_id, address, person_id, person, SUM(quantity) AS quantity FROM raw_data WHERE company = ? AND brand <> '' GROUP BY person) as raw_data " +
                        "LEFT JOIN clients_data ON raw_data.person_id = clients_data.hash_id LEFT JOIN clients_address ON raw_data.address_id = clients_address.hash_id ORDER BY quantity DESC",
                new String[]{company},
                new ClientMapper());
    }

    @Override
    public ClientDetails getClientDetailsById(Integer clientId) {
        ClientDetails details = jdbcTemplate.queryForObject(
                "SELECT * FROM (SELECT DISTINCT person_id, person, SUM(quantity) AS quantity FROM raw_data WHERE person_id=? AND brand <> '') as t LEFT JOIN clients_data ON t.person_id = clients_data.hash_id",
                new String[]{String.valueOf(clientId)},
                new ClientDetailsMapper());
        Objects.requireNonNull(details).setAddresses(jdbcTemplate.query(
                "SELECT * FROM (SELECT DISTINCT address_id, address FROM raw_data WHERE person_id=?) as t LEFT JOIN clients_address ON address_id = clients_address.hash_id",
                new String[]{String.valueOf(clientId)},
                new ClientDetailsAddressMapper()));
        Objects.requireNonNull(details).setBrands(jdbcTemplate.query(
                "SELECT DISTINCT brand, SUM(quantity) AS quantity FROM raw_data WHERE person_id=? AND brand <> '' GROUP BY brand",
                new String[]{String.valueOf(clientId)},
                new ClientDetailsBrandMapper()));
        return details;
    }

    private static class ClientMapper implements RowMapper<Client> {

        private String getName(String surname, String name, String patronymic, String person){
            if (surname == null || name == null || surname.isEmpty() || name.isEmpty()){
                return person;
            } else {
                return surname + " " + name + (patronymic == null ? "" : " " + patronymic);
            }

        }

        private String getAddress(String region, String city, String street, String address){
            if (region == null || city == null || street == null || region.isEmpty() || city.isEmpty() || street.isEmpty()){
                return address;
            } else {
                return region + ", " + city + ", " + street;
            }

        }

        @Override
        public Client mapRow(ResultSet resultSet, int i) throws SQLException {
            return Client.builder()
                    .hashId(resultSet.getInt("person_id"))
                    .name(getName(
                            resultSet.getString("surname"),
                            resultSet.getString("name"),
                            resultSet.getString("patronymic"),
                            resultSet.getString("person")))
                    .company(resultSet.getString("company"))
                    .address(getAddress(
                            resultSet.getString("region"),
                            resultSet.getString("city"),
                            resultSet.getString("street"),
                            resultSet.getString("address")
                    ))
                    .totalScore(resultSet.getDouble("quantity"))
                    .build();
        }
    }

    private static class ClientDetailsMapper implements RowMapper<ClientDetails> {

        private String getName(String surname, String name, String patronymic, String person){
            if (surname == null || name == null || surname.isEmpty() || name.isEmpty()){
                return person;
            } else {
                return surname + " " + name + (patronymic == null ? "" : " " + patronymic);
            }

        }

        @Override
        public ClientDetails mapRow(ResultSet resultSet, int i) throws SQLException {
            return ClientDetails.builder()
                    .name(getName(
                            resultSet.getString("surname"),
                            resultSet.getString("name"),
                            resultSet.getString("patronymic"),
                            resultSet.getString("person")))
                    .totalScore(resultSet.getDouble("quantity"))
                    .build();
        }
    }

    private static class ClientDetailsAddressMapper implements RowMapper<Address> {

        private Address getAddress(String region, String city, String street, String address){
            if (region == null || city == null || street == null || region.isEmpty() || city.isEmpty() || street.isEmpty()){
                return Address.builder()
                        .region("")
                        .city("")
                        .address(address)
                        .build();
            } else {
                return Address.builder()
                        .region(region)
                        .city(city)
                        .address(street)
                        .build();
            }

        }

        @Override
        public Address mapRow(ResultSet resultSet, int i) throws SQLException {
            return getAddress(
                    resultSet.getString("region"),
                    resultSet.getString("city"),
                    resultSet.getString("street"),
                    resultSet.getString("address"));
        }
    }

    private static class ClientDetailsBrandMapper implements RowMapper<Brand> {

        @Override
        public Brand mapRow(ResultSet resultSet, int i) throws SQLException {
            return Brand.builder()
                    .name(resultSet.getString("brand"))
                    .quality(resultSet.getDouble("quantity"))
                    .build();
        }
    }
}
