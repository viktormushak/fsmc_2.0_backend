package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.Sales;
import com.fsmc.backend.data.repo.ClientRepository;
import com.fsmc.backend.data.repo.SalesRepository;
import com.fsmc.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final SalesRepository salesRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, SalesRepository salesRepository) {
        this.clientRepository = clientRepository;
        this.salesRepository = salesRepository;
    }

    public List<Client> getClientsByCompany(String company) {
        return clientRepository.getAllByCompany(company);
    }

    @Override
    public List<Sales> getClientSalesByClientUuid(int clientId) {
        return salesRepository.getAllByClientUuid(clientId);
    }

    @Override
    public List<String> getClientAddressesByClientUuid(int clientId) {
        return clientRepository.getClientAddressesByClientUuid(clientId);
    }
}
