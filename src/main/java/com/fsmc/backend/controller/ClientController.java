package com.fsmc.backend.controller;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.Sales;
import com.fsmc.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{company}")
    public List<Client> getClientsByCompany(@PathVariable("company") String company){
        return clientService.getClientsByCompany(company);
    }

    @GetMapping("/details/sales/{id}")
    public List<Sales> getClientSales(@PathVariable("id") int clientId){
        return clientService.getClientSalesByClientUuid(clientId);
    }
}
