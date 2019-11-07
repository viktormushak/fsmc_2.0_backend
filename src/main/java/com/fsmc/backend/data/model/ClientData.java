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

    public static final ClientData EMPTY = new ClientData();

    private int hashId;
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
    private String email;

}
