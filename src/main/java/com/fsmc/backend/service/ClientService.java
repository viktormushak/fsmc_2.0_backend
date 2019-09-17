package com.fsmc.backend.service;

import com.fsmc.backend.data.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getClientsByCompany(String company);
}
