package com.fsmc.backend.service;

import com.fsmc.backend.data.network.RawDataReport;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RawDataService {
    RawDataReport execute(String company, MultipartFile file) throws IOException;
}
