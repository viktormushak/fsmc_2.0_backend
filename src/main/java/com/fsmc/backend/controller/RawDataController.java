package com.fsmc.backend.controller;

import com.fsmc.backend.service.RawDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/raw")
public class RawDataController {

    private final RawDataService rawDataService;

    @Autowired
    public RawDataController(RawDataService rawDataService) {
        this.rawDataService = rawDataService;
    }

    @GetMapping
    public void saveData() throws IOException {
        rawDataService.execute();
    }
}
