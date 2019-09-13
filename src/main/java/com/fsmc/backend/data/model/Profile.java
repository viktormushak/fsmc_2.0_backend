package com.fsmc.backend.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    public static final Profile EMPTY = new Profile();

    private int uuid;
    private String rawData;
    private String rawAddress;
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String phone;
    private String region;
    private String city;
    private String street;
    private String building;
}
