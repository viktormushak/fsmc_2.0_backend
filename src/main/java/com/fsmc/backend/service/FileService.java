package com.fsmc.backend.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Optional;

public interface FileService {
    Optional<File> saveMultipartFile(String name, MultipartFile file);
}
