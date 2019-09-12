package com.fsmc.backend.utils.csv.impl;

import com.fsmc.backend.utils.csv.CsvRows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvRowsImpl implements CsvRows {

    private String schema;
    private String delimiter;
    private List<Map<String, String>> values;

    public CsvRowsImpl(String schema, String delimiter) {
        this.schema = schema;
        this.delimiter = delimiter;
        this.values = new ArrayList<>();
    }

    public void put(String[] strings){
        Map<String, String> map = new HashMap<>();
        String[] schemaColumns = schema.split(delimiter);
        for (int i = 0; i < schemaColumns.length; i++) {
            map.put(schemaColumns[i], strings[i]);
        }
        values.add(map);
    }
}
