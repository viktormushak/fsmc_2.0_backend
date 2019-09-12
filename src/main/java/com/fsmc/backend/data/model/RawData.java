package com.fsmc.backend.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RawData {

    private int id;
    private String companyName;
    private int aUuid;
    private String rAddress;
    private int eUuid;
    private String rEmployee;
    private int sUuid;
    private String rSale;
    private double quantity;
}
