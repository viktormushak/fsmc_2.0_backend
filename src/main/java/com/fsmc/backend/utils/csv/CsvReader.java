package com.fsmc.backend.utils.csv;

import com.fsmc.backend.utils.csv.impl.CsvRowsImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CsvReader {

    private String schema;
    private String delimiter;
    private CsvRows csvRows;

    public CsvReader(String schema, String delimiter) {
        this.schema = schema;
        this.delimiter = delimiter;
        this.csvRows = new CsvRowsImpl(schema, delimiter);
    }

    public CsvReader openFile(File file) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String fileSchema = bufferedReader.readLine();

        if (!fileSchema.contains(delimiter)){
            throw new Exception("Bad CSV file. Can not find delimiter!");
        }

        String[] schemaColumns = schema.split(delimiter);
        String[] fileColumns = fileSchema.split(delimiter);

        for (int i = 0; i < schemaColumns.length; i++) {
            if (!schemaColumns[i].equals(fileColumns[i])){
                throw new Exception("Bad CSV file. Can not valid file schema!");
            }
        }

        String row;
        while ((row = bufferedReader.readLine()) != null) {
            csvRows.put(row.split(delimiter));
        }

        return this;
    }
}
