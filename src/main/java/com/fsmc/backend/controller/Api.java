package com.fsmc.backend.controller;

import com.fsmc.backend.data.model.Company;
import com.fsmc.backend.data.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Api {

    private final CompanyRepository companyRepository;

    @Autowired
    public Api(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/companies")
    public List<Company> getCompanies(){
        return companyRepository.getAll();
    }
}
