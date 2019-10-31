package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.ClientDetails;

import java.util.List;

public interface ClientRepository {
    List<Client> getAll();
    List<Client> getAllByCompany(String company);
    ClientDetails getClientDetailsById(Integer clientId);
}
