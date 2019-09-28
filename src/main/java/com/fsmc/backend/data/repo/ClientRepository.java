package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.Client;
import com.fsmc.backend.data.model.Sales;

import java.util.List;

public interface ClientRepository {
    List<Client> getAllByCompany(String company);
}
