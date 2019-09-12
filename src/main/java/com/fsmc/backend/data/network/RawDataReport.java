package com.fsmc.backend.data.network;

import lombok.Data;

import java.util.List;

@Data
public class RawDataReport {

    private int successStrings;
    private int crashedStrings;
    private List<String> crashedList;

    public RawDataReport(int successStrings, List<String> crashedStrings) {
        this.successStrings = successStrings;
        this.crashedStrings = crashedStrings.size();
        this.crashedList = crashedStrings;
    }
}
