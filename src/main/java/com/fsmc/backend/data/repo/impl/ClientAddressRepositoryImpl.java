package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Address;
import com.fsmc.backend.data.repo.ClientAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class ClientAddressRepositoryImpl implements ClientAddressRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientAddressRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Address getByClientId(int id) {
        String query = "select * from (select distinct address_id, address from raw_data where person_id=?) as t left join clients_address on t.address_id = clients_address.hash_id";
        return jdbcTemplate.queryForObject(query, new Integer[]{id}, (resultSet, i) -> Address.builder()
                .region(resultSet.getString("region"))
                .city(resultSet.getString("city"))
                .address(getAddress(
                        resultSet.getString("region"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getString("address")))
                .build());
    }

    @Override
    public Address save(Address address, Integer clientId) {
        try{
            int hashId = Objects.hash(address.getRegion(), address.getCity(), address.getAddress());
            jdbcTemplate.update("UPDATE raw_data SET address_id = ?, address = ? WHERE person_id = ?",
                    hashId,
                    address.getRegion() + ", " + address.getCity() + ", " + address.getAddress(),
                    clientId);
            try{
                jdbcTemplate.update("INSERT INTO clients_address (hash_id, region, city, street) VALUES (?, ?, ?, ?)",
                        hashId,
                        address.getRegion(),
                        address.getCity(),
                        address.getAddress());
            } catch (Exception e) {
                jdbcTemplate.update("UPDATE clients_address SET region = ?, city = ?, street = ? WHERE hash_id = ?",
                        address.getRegion(),
                        address.getCity(),
                        address.getAddress(),
                        hashId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return getByClientId(clientId);
    }

    private String getAddress(String region, String city, String street, String address){
        if (region == null || city == null || street == null || region.isEmpty() || city.isEmpty() || street.isEmpty()){
            return address;
        } else {
            return street;
        }

    }
}
