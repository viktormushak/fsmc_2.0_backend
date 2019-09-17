package com.fsmc.backend.service;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.Sales;

import java.util.List;

public interface ClientService {
    List<Client> getClientsByCompany(String company);

    List<Sales> getClientSalesByClientUuid(int clientId);

    List<String> getClientAddressesByClientUuid(int clientId);
}
