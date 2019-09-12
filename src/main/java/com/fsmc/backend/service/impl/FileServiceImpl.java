package com.fsmc.backend.service.impl;

import com.fsmc.backend.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    private static final String UPLOAD_DIR = System.getProperty("user.home") + "/.fsmc_raw_data";
    private boolean isUploadDirInit;

    public FileServiceImpl() {
        initUploadDir();
    }

    private void initUploadDir() {
        File uploadDir = new File(UPLOAD_DIR);
        isUploadDirInit = uploadDir.exists() || uploadDir.mkdirs();
    }

    public Optional<File> saveMultipartFile(String name, MultipartFile file) {
        return isUploadDirInit ?  saveFile(name, file) : Optional.empty();
    }

    private Optional<File> saveFile(String name, MultipartFile file) {
        try {
            File uploadedFile = new File(UPLOAD_DIR, name + "-" + System.currentTimeMillis() + ".csv");
            FileOutputStream fileOutputStream = new FileOutputStream(uploadedFile);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            return Optional.of(uploadedFile);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
