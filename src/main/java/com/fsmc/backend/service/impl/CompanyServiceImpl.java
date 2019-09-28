package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.Company;
import com.fsmc.backend.data.repo.CompanyRepository;
import com.fsmc.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.getAll();
    }
}
