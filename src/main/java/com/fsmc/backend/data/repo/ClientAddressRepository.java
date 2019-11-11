package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.Address;

public interface ClientAddressRepository {
    Address getByClientId(int id);
    Address save(Address data, Integer clientId);
}
