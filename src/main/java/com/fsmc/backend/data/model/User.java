package com.fsmc.backend.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public static final User EMPTY = new User();

    private String uuid;
    private String password;
    private String authority;
    private boolean enabled;
}
