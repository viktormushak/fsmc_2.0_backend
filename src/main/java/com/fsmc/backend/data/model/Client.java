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

    private int hashId;
    private String name;
    private String company;
    private String address;
    private double totalScore;

}
