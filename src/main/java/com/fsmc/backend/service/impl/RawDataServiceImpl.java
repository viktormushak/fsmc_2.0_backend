package com.fsmc.backend.service.impl;

import com.fsmc.backend.data.model.RawData;
import com.fsmc.backend.data.network.RawDataReport;
import com.fsmc.backend.data.repo.RawDataRepository;
import com.fsmc.backend.service.FileService;
import com.fsmc.backend.service.RawDataService;
import com.fsmc.backend.service.impl.adapters.*;
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
    }

    @Override
    public RawDataReport execute(String company, MultipartFile multipartFile) {
        this.rawDataList = new ArrayList<>();
        this.crashedStrings = new ArrayList<>();
        final String[] exceptionMessage = new String[1];
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
                if (!rawDataList.isEmpty()){
                    successStrings = rawDataRepository.save(rawDataList);
                    if (successStrings > 0){
                        rawDataRepository.setCompanyUpdate(
                                ((AbsCompanyRawDataAdapter) companyRawDataAdapter).getCompanyName(),
                                System.currentTimeMillis());
                    }
                }
            } catch (Exception e) {
                exceptionMessage[0] = e.getMessage();
            }
        });
        return new RawDataReport(successStrings, crashedStrings, exceptionMessage[0]);
    }

    private CompanyRawDataAdapter getCompanyAdapter(String company) throws Exception {
        if ("Здравица".toLowerCase().equals(company.toLowerCase())){
            return new ZdravitsaDataAdapter();
        } else if ("Провизор".toLowerCase().equals(company.toLowerCase())){
            return new ProvizorDataAdapter();
        } else if ("Астарта".toLowerCase().equals(company.toLowerCase())){
            return new AstartaDataAdapter();
        } else if ("СВ_Медикал".toLowerCase().equals(company.toLowerCase())){
            return new SVDataAdapter();
        } else if ("Витамин".toLowerCase().equals(company.toLowerCase())){
            return new VitaminRawDataAdapter();
        } else if ("Аптека_36,6".toLowerCase().equals(company.toLowerCase())){
            return new Apteka36i6DataAdapter();
        } else if ("Галафарм".toLowerCase().equals(company.toLowerCase())){
            return new GalafarmDataAdapter();
        } else if ("Сириус".toLowerCase().equals(company.toLowerCase())){
            return new SiriusDataAdapter();
        } else if ("Арника".toLowerCase().equals(company.toLowerCase())){
            return new ArnikaDataAdapter();
        } else if ("Волыньфарм".toLowerCase().equals(company.toLowerCase())){
            return new VolynfarmDataAdapter();
        } else if ("Наталка".toLowerCase().equals(company.toLowerCase())){
            return new NatalkaDataAdapter();
        } else if ("Виталюкс".toLowerCase().equals(company.toLowerCase())){
            return new VitaluxDataAdapter();
        } else if ("Акс".toLowerCase().equals(company.toLowerCase())){
            return new AksDataAdapter();
        } else if ("Первоцвет".toLowerCase().equals(company.toLowerCase())){
            return new PervotsvetDataAdapter();
        } else if ("Гамма".toLowerCase().equals(company.toLowerCase())){
            return new GammaDataAdapter();
        } else {
            throw new Exception("Wrong company name: " + company);
        }
    }

}
