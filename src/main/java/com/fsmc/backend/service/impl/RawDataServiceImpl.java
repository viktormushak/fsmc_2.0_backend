package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.RawData;
import com.fsmc.backend.data.network.RawDataReport;
import com.fsmc.backend.data.repo.RawDataRepository;
import com.fsmc.backend.service.FileService;
import com.fsmc.backend.service.RawDataService;
import com.fsmc.backend.utils.csv.CsvReader;
import com.fsmc.backend.utils.csv.CsvRows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RawDataServiceImpl implements RawDataService {

    private final FileService fileService;
    private final RawDataRepository rawDataRepository;
    private List<RawData> rawDataList;
    private List<String> crashedStrings;
    private int successStrings;

    @Autowired
    public RawDataServiceImpl(FileService fileService, RawDataRepository rawDataRepository) {
        this.fileService = fileService;
        this.rawDataRepository = rawDataRepository;
        this.rawDataList = new ArrayList<>();
        this.crashedStrings = new ArrayList<>();
    }

    @Override
    public RawDataReport execute(String company, MultipartFile multipartFile) {

        Optional<File> uploadedFile = fileService.saveMultipartFile(company, multipartFile);

        uploadedFile.ifPresent(file -> {
            try {
                CsvReader csvReader = new CsvReader("Company;Address;Person;Sku;Quantity", ";");
                CsvRows rows = csvReader.openFile(file).getRows();
                rows.foreach(row -> {
                    RawData rawData = null;
                    try {
                        rawData = RawData.builder()
                                .companyName(row.get("Company"))
                                .aUuid(Objects.hash(row.get("Company"), row.get("Address")))
                                .rAddress(row.get("Address"))
                                .eUuid(Objects.hash(row.get("Company"), row.get("Person")))
                                .rEmployee(row.get("Person"))
                                .sUuid(Objects.hash(row.get("Person"), row.get("Sku")))
                                .rSale(row.get("Sku"))
                                .quantity(Double.parseDouble(row.get("Quantity")))
                                .build();
                    }catch (Exception e){
                        crashedStrings.add(row.toString());
                    } finally {
                        if (rawData != null){
                            rawDataList.add(rawData);
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        if (!rawDataList.isEmpty()){
            successStrings = rawDataRepository.save(rawDataList);
        }
        return new RawDataReport(successStrings, crashedStrings);
    }
}
