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

    public static final ClientDetails EMPTY = new ClientDetails();

    private String name;
    private double totalScore;
    private List<Address> addresses;
    private List<Brand> brands;

}
