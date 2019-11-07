package com.fsmc.backend.controller;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.ClientData;
import com.fsmc.backend.data.model.ClientDetails;
import com.fsmc.backend.data.model.Company;
import com.fsmc.backend.data.network.RawDataReport;
import com.fsmc.backend.service.ClientService;
import com.fsmc.backend.service.CompanyService;
import com.fsmc.backend.service.RawDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Api {

    private final CompanyService companyService;
    private final ClientService clientService;
    private final RawDataService rawDataService;

    @Autowired
    public Api(CompanyService companyService, ClientService clientService, RawDataService rawDataService) {
        this.companyService = companyService;
        this.clientService = clientService;
        this.rawDataService = rawDataService;
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

    @PostMapping("/clients/data")
    public ClientData.Result saveClientData(@RequestBody ClientData data){
        return clientService.saveClientData(data);
    }

    @GetMapping("/clients/data")
    public ClientData getClientDataById(@RequestParam("id") Integer clientId){
        return clientService.getClientDataById(clientId);
    }

    @PostMapping("/raw")
    public RawDataReport postRawDataByCompany(@RequestParam("company") String company,
                                              @RequestParam("file") MultipartFile file) throws IOException {
        return rawDataService.execute(company, file);
    }
}
