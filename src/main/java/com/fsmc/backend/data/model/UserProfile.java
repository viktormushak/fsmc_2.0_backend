package com.fsmc.backend.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    public static final UserProfile EMPTY = new UserProfile();

    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String phone;
}
