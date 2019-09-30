package com.fsmc.backend.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDetails {

    private String name;
    private double totalScore;
    private List<Address> addresses;
    private List<Brand> brands;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Brand {
        private String name;
        private double quality;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {
        private String address;
        private String region;
        private String city;
        private String street;
    }
}
