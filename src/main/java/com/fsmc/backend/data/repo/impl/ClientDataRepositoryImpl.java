package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.ClientData;
import com.fsmc.backend.data.repo.ClientDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDataRepositoryImpl implements ClientDataRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDataRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ClientData getById(int id) {
        String query = "select * from clients_data where hash_id=?";
        return jdbcTemplate.queryForObject(query, new Integer[]{id}, (resultSet, i) -> ClientData.builder()
                .hashId(id)
                .name(resultSet.getString("name"))
                .surname(resultSet.getString("surname"))
                .patronymic(resultSet.getString("patronymic"))
                .phone(resultSet.getString("phone"))
                .email(resultSet.getString("email"))
                .build());
    }

    @Override
    public ClientData save(ClientData data) {
        String sql = "INSERT INTO clients_data (hash_id, name, surname, patronymic, phone, email) VALUES (?, ?, ?, ?, ?, ?)";
        try{
            jdbcTemplate.update(sql,
                    data.getHashId(),
                    data.getName(),
                    data.getSurname(),
                    data.getPatronymic(),
                    data.getPhone(),
                    data.getEmail());
        }catch (Exception e){
            String query = "UPDATE clients_data SET name = ?, surname = ?, patronymic = ?, phone = ?, email = ? WHERE hash_id = ?";
            jdbcTemplate.update(query,
                    data.getName(),
                    data.getSurname(),
                    data.getPatronymic(),
                    data.getPhone(),
                    data.getEmail(),
                    data.getHashId());
        }
        return getById(data.getHashId());
    }
}
