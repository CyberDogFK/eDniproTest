package com.ednipro.dniprotesttask.service.impl;

import com.ednipro.dniprotesttask.model.WorkbookModel;
import com.ednipro.dniprotesttask.service.PdfService;
import com.ednipro.dniprotesttask.service.StorageService;
import com.ednipro.dniprotesttask.service.WorkbookService;
import com.ednipro.dniprotesttask.service.XlsFileReaderService;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService {
    private final WorkbookService workbookService;
    private final PdfService pdfService;
    private final XlsFileReaderService xlsFileService;
    private final Path root = Paths.get("uploads");

    public StorageServiceImpl(WorkbookService workbookService,
                              PdfService pdfService,
                              XlsFileReaderService xlsFileService) {
        this.workbookService = workbookService;
        this.pdfService = pdfService;
        this.xlsFileService = xlsFileService;
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    public void save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                try {
                    Files.delete(root.resolve(file.getOriginalFilename()));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                save(file);
                return;
            }
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public Resource reworkExcelToPdf(MultipartFile file) {
        save(file);
        WorkbookModel workbookModel = xlsFileService.saveWorkbookToDb("uploads/"
                + file.getOriginalFilename());
        WorkbookModel wmodel = workbookService.getById(workbookModel.getId());
        String s = pdfService.makePdfFromWorkbook(wmodel);
        return load(s);
    }
}
