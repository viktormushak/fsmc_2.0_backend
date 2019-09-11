package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.Company;

import java.util.List;

public interface CompanyRepository {

    List<Company> getCompaniesByResponsibleUsername(String username);
}
