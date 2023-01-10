package com.ednipro.dniprotesttask.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
    void init();

    void save(MultipartFile file);

    Resource load(String filename);

    Resource reworkExcelToPdf(MultipartFile file);
}
