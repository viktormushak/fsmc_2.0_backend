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

        String sql = "INSERT INTO raw_data (" +
                "company_name, a_uuid, r_address, e_uuid, r_employee, s_uuid, r_sale, quantaty) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        RawData rawData = rawDataList.get(i);
                        ps.setString(1, rawData.getCompanyName());
                        ps.setInt(2, rawData.getAUuid());
                        ps.setString(3, rawData.getRAddress());
                        ps.setInt(4, rawData.getEUuid());
                        ps.setString(5, rawData.getREmployee());
                        ps.setInt(6, rawData.getSUuid());
                        ps.setString(7, rawData.getRSale());
                        ps.setDouble(8, rawData.getQuantity());
                    }
                    @Override
                    public int getBatchSize() {
                        return rawDataList.size();
                    }
                }).length;
    }
}
