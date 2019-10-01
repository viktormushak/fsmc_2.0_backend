package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.RawData;
import com.fsmc.backend.data.network.RawDataReport;
import com.fsmc.backend.data.repo.RawDataRepository;
import com.fsmc.backend.service.FileService;
import com.fsmc.backend.service.RawDataService;
import com.fsmc.backend.utils.csv.CsvReader;
import com.fsmc.backend.utils.csv.CsvRows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

@Service
public class RawDataServiceImpl implements RawDataService {

    private Logger logger = LoggerFactory.getLogger(RawDataService.class);
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
                CompanyRawDataAdapter companyRawDataAdapter = getCompanyAdapter(company);
                rows.foreach(row -> {
                    RawData rawData = null;
                    try {
                        rawData = companyRawDataAdapter.apply(row);
                    }catch (Exception e){
                        crashedStrings.add(row.toString());
                    } finally {
                        if (rawData != null){
                            rawDataList.add(rawData);
                            logger.info("Added rawData: " + rawData );
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        if (!rawDataList.isEmpty()){
            successStrings = rawDataRepository.save(rawDataList);
            if (successStrings > 0){
                rawDataRepository.setCompanyUpdate(company, System.currentTimeMillis());
            }
        }
        return new RawDataReport(successStrings, crashedStrings);
    }

    private CompanyRawDataAdapter getCompanyAdapter(String company){
        if ("Волыньфарм".toLowerCase().equals(company.toLowerCase()) || "Волиньфарм".toLowerCase().equals(company.toLowerCase())){
            return new VFAdapter();
        }

        return csvRows -> null;
    }

    private interface CompanyRawDataAdapter {
        RawData apply(Map<String, String> row);
    }

    private class VFAdapter implements CompanyRawDataAdapter {

        private static final String COMPANY_NAME = "Волиньфарм";

        @Override
        public RawData apply(Map<String, String> row) {
            String address = row.get("Address");
            String person = row.get("Person");
            String sku = row.get("Sku");
            String brand = getBrandBySku(sku);
            double quantity = Double.parseDouble(row.get("Quantity")) * getIndexBySku(sku);
            return RawData.builder()
                    .company(COMPANY_NAME)
                    .addressId(Objects.hash(COMPANY_NAME, address))
                    .address(address)
                    .personId(Objects.hash(COMPANY_NAME, person))
                    .person(person)
                    .skuId(Objects.hash(person, sku))
                    .sku(sku)
                    .brand(brand)
                    .quantity(quantity)
                    .build();
        }

        private String getBrandBySku(String sku) {
            if ("Ринт наз спрей  з ментолом 0,5мг/г 10г Фармак".equals(sku)){
                return "Ринт";
            } else if ("Ринт наз спрей зволожуючий 0,5мг/г 10г Фармак".equals(sku)){
                return "Ринт";
            } else {
                return null;
            }
        }

        private double getIndexBySku(String sku) {
            return 1;
        }
    }
}
