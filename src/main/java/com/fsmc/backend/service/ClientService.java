package com.fsmc.backend.service;

import com.fsmc.backend.data.model.Address;
import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.ClientData;
import com.fsmc.backend.data.model.ClientDetails;

import java.util.List;

public interface ClientService {
    List<Client> getClientsByCompany(String company);
    ClientDetails getClientDetailsById(Integer clientId);
    ClientData getClientDataById(Integer clientId);
    ClientData saveClientData(ClientData data);
    Address getClientAddressById(Integer clientId);
    Address saveClientAddress(Address data, Integer clientId);
}
