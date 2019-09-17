package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.RawData;

import java.util.List;

public interface RawDataRepository {

    int save(List<RawData> rawDataList);

    void setCompanyUpdate(String company, long update);
}
