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
    private String company;
    private int addressId;
    private String address;
    private int personId;
    private String person;
    private int skuId;
    private String sku;
    private String brand;
    private double quantity;
}
