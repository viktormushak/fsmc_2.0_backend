package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.Credentials;

public interface CredentialsRepository {
    int save(Credentials credentials);
}
