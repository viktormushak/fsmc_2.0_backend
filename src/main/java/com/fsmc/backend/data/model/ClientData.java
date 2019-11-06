package com.fsmc.backend.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientData {

    private int hashId;
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
    private String email;
    private boolean hasEmail;
}
