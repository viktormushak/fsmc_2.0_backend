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
    private String name;
    private String surname;
    private String email;
    private String phone;
}
