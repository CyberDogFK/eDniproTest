package com.ednipro.dniprotesttask.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void init();

    void save(MultipartFile file);

    Resource load(String filename);

    Resource reworkExcelToPdf(MultipartFile file);
}
