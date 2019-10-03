package com.fsmc.backend.service.impl.adapters;

import com.fsmc.backend.data.model.RawData;

import java.util.Map;

public interface CompanyRawDataAdapter {
    RawData apply(Map<String, String> row);
}
