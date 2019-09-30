package com.fsmc.backend.service;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.ClientDetails;

import java.util.List;

public interface ClientService {
    List<Client> getClientsByCompany(String company);
    ClientDetails getClientDetailsById(Integer clientId);
}
