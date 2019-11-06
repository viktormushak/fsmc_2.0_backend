package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.ClientData;
import com.fsmc.backend.data.model.ClientDetails;
import com.fsmc.backend.data.repo.ClientDataRepository;
import com.fsmc.backend.data.repo.ClientRepository;
import com.fsmc.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientDataRepository clientDataRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, ClientDataRepository clientDataRepository) {
        this.clientRepository = clientRepository;
        this.clientDataRepository = clientDataRepository;
    }

    @Override
    public List<Client> getClientsByCompany() {
        return clientRepository.getAll();
    }

    public List<Client> getClientsByCompany(String company) {
        return clientRepository.getAllByCompany(company);
    }

    @Override
    public ClientDetails getClientDetailsById(Integer clientId) {
        return clientRepository.getClientDetailsById(clientId);
    }

    @Override
    public ClientData getClientDataById(Integer clientId) {
        return clientDataRepository.getById(clientId);
    }

    @Override
    public ClientData.Result saveClientData(ClientData data) {
        return clientDataRepository.save(data);
    }

}
