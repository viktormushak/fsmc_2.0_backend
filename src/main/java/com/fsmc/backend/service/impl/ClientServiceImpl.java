package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.ClientDetails;
import com.fsmc.backend.data.repo.ClientRepository;
import com.fsmc.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClientsByCompany(String company) {
        return clientRepository.getAllByCompany(company);
    }

    @Override
    public ClientDetails getClientDetailsById(Integer clientId) {
        return clientRepository.getClientDetailsById(clientId);
    }

}
