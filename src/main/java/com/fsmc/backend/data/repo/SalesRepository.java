package com.fsmc.backend.data.repo;

import com.fsmc.backend.data.model.Sales;

import java.util.List;

public interface SalesRepository {
    List<Sales> getAllByClientUuid(int clientId);
}
