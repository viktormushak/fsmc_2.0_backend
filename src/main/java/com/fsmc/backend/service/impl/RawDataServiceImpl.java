package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.RawData;
import com.fsmc.backend.data.network.RawDataReport;
import com.fsmc.backend.data.repo.RawDataRepository;
import com.fsmc.backend.service.FileService;
import com.fsmc.backend.service.RawDataService;
import com.fsmc.backend.utils.csv.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

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

                CsvReader csvReader = new CsvReader("Address;Person;Sku;Quantity", ";");
                csvReader.openFile(file);
//                String string;
//                RawData rawData = null;
//                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//                while ((string = bufferedReader.readLine()) != null) {
//                    String[] strings = string.split(";");
//                    try {
//                        rawData = RawData.builder()
//                                .companyName(company)
//                                .aUuid(Objects.hash(company, strings[1]))
//                                .rAddress(strings[1])
//                                .eUuid(Objects.hash(company, strings[3]))
//                                .rEmployee(strings[3])
//                                .sUuid(Objects.hash(strings[3], strings[2]))
//                                .rSale(strings[2])
//                                .quantity(Double.parseDouble(strings[4]))
//                                .build();
//                    }catch (Exception e){
//                        crashedStrings.add(string);
//                    } finally {
//                        if (rawData != null){
//                            rawDataList.add(rawData);
//                        }
//                    }
//                }
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
