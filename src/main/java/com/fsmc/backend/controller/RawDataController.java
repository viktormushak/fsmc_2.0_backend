package com.fsmc.backend.controller;

import com.fsmc.backend.data.network.RawDataReport;
import com.fsmc.backend.service.RawDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/raw")
public class RawDataController {

    private final RawDataService rawDataService;

    @Autowired
    public RawDataController(RawDataService rawDataService) {
        this.rawDataService = rawDataService;
    }

    @PostMapping("/load/{company}")
    public RawDataReport saveData(@PathVariable("company") String company,
                                  @RequestParam("file") MultipartFile file) throws IOException {
        return rawDataService.execute(company, file);
    }
}
