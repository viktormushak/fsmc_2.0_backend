package com.fsmc.backend.controller;

import com.fsmc.backend.data.network.Result;
import com.fsmc.backend.data.repo.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping
    public Result getCompanies(OAuth2Authentication authentication){
        return new Result.Success<>(companyRepository.getCompaniesByResponsibleUsername((String) authentication.getPrincipal()));
    }
}
