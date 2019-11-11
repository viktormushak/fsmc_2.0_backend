package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.Address;
import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.ClientData;
import com.fsmc.backend.data.model.ClientDetails;
import com.fsmc.backend.data.repo.ClientAddressRepository;
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
    private final ClientAddressRepository clientAddressRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository,
                             ClientDataRepository clientDataRepository,
                             ClientAddressRepository clientAddressRepository) {
        this.clientRepository = clientRepository;
        this.clientDataRepository = clientDataRepository;
        this.clientAddressRepository = clientAddressRepository;
    }

    public List<Client> getClientsByCompany(String company) {
        return company.equals("null") ? clientRepository.getAll() : clientRepository.getAllByCompany(company);
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
    public ClientData saveClientData(ClientData data) {
        return clientDataRepository.save(data);
    }

    @Override
    public Address getClientAddressById(Integer clientId) {
        return clientAddressRepository.getByClientId(clientId);
    }

    @Override
    public Address saveClientAddress(Address address, Integer clientId) {
        return clientAddressRepository.save(address, clientId);
    }

}
