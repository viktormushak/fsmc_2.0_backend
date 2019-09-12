package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.RawData;

import java.io.IOException;
import java.util.List;

public interface RawDataRepository {

    void execute(List<RawData> rawDataList) throws IOException;
}
