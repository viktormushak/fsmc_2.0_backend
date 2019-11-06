package com.fsmc.backend.service.impl.adapters;

import com.fsmc.backend.data.model.RawData;

import java.util.Map;
import java.util.Objects;

public abstract class AbsCompanyRawDataAdapter implements CompanyRawDataAdapter {

    private String companyName;

    AbsCompanyRawDataAdapter(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public RawData apply(Map<String, String> row) {
        String address = row.get("Address");
        String person = row.get("Person");
        String sku = row.get("Sku");
        String brand = getBrandBySku(sku);
        double quantity = Double.parseDouble(row.get("Quantity")) * getIndexBySku(sku);
        return RawData.builder()
                .company(companyName)
                .addressId(Objects.hash(companyName, address))
                .address(address)
                .personId(Objects.hash(companyName, person))
                .person(person)
                .skuId(Objects.hash(person, sku))
                .sku(sku)
                .brand(brand)
                .quantity(quantity)
                .build();
    }

    protected abstract String getBrandBySku(String sku);

    protected abstract double getIndexBySku(String sku);
}
