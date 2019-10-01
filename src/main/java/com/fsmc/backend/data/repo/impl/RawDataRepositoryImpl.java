package com.fsmc.backend.data.repo.impl;

import com.fsmc.backend.data.model.RawData;
import com.fsmc.backend.data.repo.RawDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RawDataRepositoryImpl implements RawDataRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RawDataRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(List<RawData> rawDataList) {

        String sql = "INSERT INTO raw_data (company, address_id, address, person_id, person, sku_id, sku, brand, quantity) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        RawData rawData = rawDataList.get(i);
                        ps.setString(1, rawData.getCompany());
                        ps.setInt(2, rawData.getAddressId());
                        ps.setString(3, rawData.getAddress());
                        ps.setInt(4, rawData.getPersonId());
                        ps.setString(5, rawData.getPerson());
                        ps.setInt(6, rawData.getSkuId());
                        ps.setString(7, rawData.getSku());
                        ps.setString(8, rawData.getBrand());
                        ps.setDouble(9, rawData.getQuantity());
                    }
                    @Override
                    public int getBatchSize() {
                        return rawDataList.size();
                    }
                }).length;
    }

    @Override
    public void setCompanyUpdate(String company, long update) {
        String sql = "INSERT INTO companies (company, last_update) VALUES (?, ?)";
        jdbcTemplate.update(sql, company, update);
    }
}
