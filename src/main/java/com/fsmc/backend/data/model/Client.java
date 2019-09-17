package com.fsmc.backend.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    private int position;
    private int uuid;
    private String name;
    private String companyName;
    private String address;
    private double score;
}
