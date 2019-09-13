package com.fsmc.backend.service;

import com.fsmc.backend.data.model.Credentials;

public interface CredentialsService {
    Credentials saveNewCredentials(Credentials credentials);
}
