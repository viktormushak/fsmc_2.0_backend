package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.ClientData;

public interface ClientDataRepository {
    ClientData getById(int id);
    ClientData save(ClientData data);
}
