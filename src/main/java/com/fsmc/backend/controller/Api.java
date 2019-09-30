package com.fsmc.backend.controller;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.ClientDetails;
import com.fsmc.backend.data.model.Company;
import com.fsmc.backend.service.ClientService;
import com.fsmc.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Api {

    private final CompanyService companyService;
    private final ClientService clientService;

    @Autowired
    public Api(CompanyService companyService, ClientService clientService) {
        this.companyService = companyService;
        this.clientService = clientService;
    }

    @GetMapping("/companies")
    public List<Company> getCompanies(){
        return companyService.getAll();
    }

    @GetMapping("/clients")
    public List<Client> getClientsByCompany(@RequestParam("company") String company){
        return clientService.getClientsByCompany(company);
    }

    @GetMapping("/clients/details")
    public ClientDetails getClientDetailsById(@RequestParam("id") Integer clientId){
        return clientService.getClientDetailsById(clientId);
    }
}
