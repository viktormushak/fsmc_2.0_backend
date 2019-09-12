package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.RawData;
import com.fsmc.backend.data.repo.RawDataRepository;
import com.fsmc.backend.service.RawDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class RawDataServiceImpl implements RawDataService {

    private final RawDataRepository rawDataRepository;

    @Autowired
    public RawDataServiceImpl(RawDataRepository rawDataRepository) {
        this.rawDataRepository = rawDataRepository;
    }

    @Override
    public void execute() throws IOException {
        File csvFile = new File("gamma_utf.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
        String string;
        List<RawData> rawDataList = new ArrayList<>();
        while ((string = bufferedReader.readLine()) != null) {

            String[] strings = string.split(";");
            String companyName = "Гамма";
            int aUuid = Objects.hash(companyName, strings[1]);
            String rAddress = strings[1];
            int eUuid = Objects.hash(companyName, strings[3]);
            String rEmployee = strings[3];
            int sUuid = Objects.hash(rEmployee, strings[2]);
            String rSale = strings[2];
            double quantity = 0;
            try {
                quantity = Double.parseDouble(strings[4]);
            }catch (Exception e){
                e.printStackTrace();
            }
            rawDataList.add(RawData.builder()
                    .companyName(companyName)
                    .aUuid(aUuid)
                    .rAddress(rAddress)
                    .eUuid(eUuid)
                    .rEmployee(rEmployee)
                    .sUuid(sUuid)
                    .rSale(rSale)
                    .quantity(quantity)
                    .build());
        }

        rawDataRepository.execute(rawDataList);
    }
}
