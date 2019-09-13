package com.fsmc.backend.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {

    public static final Credentials EMPTY = new Credentials();

    private String username;
    private String password;
    private String authority;
    private boolean enabled;
}
