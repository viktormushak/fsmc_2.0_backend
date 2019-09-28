package com.fsmc.backend.data.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Client {

    private String name;
    private String company;
    private String address;
    private double totalScore;

    public Client(String name, String company, String address, double totalScore) {
        this.name = name;
        this.company = company;
        this.address = address;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public double getTotalScore() {
        return totalScore;
    }
}
