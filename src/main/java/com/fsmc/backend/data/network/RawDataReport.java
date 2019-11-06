package com.fsmc.backend.data.network;

import lombok.Data;

import java.util.List;

@Data
public class RawDataReport {

    private int successStrings;
    private int crashedStrings;
    private List<String> crashedList;
    private String error;

    public RawDataReport(int successStrings, List<String> crashedStrings, String error) {
        this.successStrings = successStrings;
        this.crashedStrings = crashedStrings.size();
        this.crashedList = crashedStrings;
        this.error = error;
    }
}
