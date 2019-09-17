package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.Sales;
import com.fsmc.backend.data.repo.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class SalesRepositoryImpl implements SalesRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Sales> getAllByClientUuid(int clientId) {
        return jdbcTemplate.query(
                "SELECT DISTINCT e_uuid, r_sale, SUM(quantity) as quantity" +
                        " from raw_data where e_uuid = ? group by r_sale",
                new String[]{String.valueOf(clientId)},
                new SalesMapper());
    }


    private static class SalesMapper implements RowMapper<Sales> {

        @Override
        public Sales mapRow(ResultSet resultSet, int i) throws SQLException {
            return Sales.builder()
                    .clientId(resultSet.getInt("e_uuid"))
                    .brandName(resultSet.getString("r_sale"))
                    .brandScore(resultSet.getDouble("quantity"))
                    .build();
        }
    }
}
