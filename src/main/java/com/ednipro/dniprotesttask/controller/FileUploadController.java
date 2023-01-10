package com.ednipro.dniprotesttask.controller;

import com.ednipro.dniprotesttask.service.StorageService;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileUploadController {
    private final StorageService storageService;

    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostConstruct
    private void init() {
        storageService.init();
    }

    @RequestMapping("/")
    @ResponseBody
    @ApiOperation("Redirect user to html page with pretty form for upload file ")
    public ModelAndView listUploadedFiles() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("uploadForm");
        return modelAndView;
    }

    @PostMapping("/upload")
    @ResponseBody
    @ApiOperation("Take post request with excel file, rework it to pdf, and save data from it to db,"
            + " and return pdf file for downloading")
    public ResponseEntity<Resource> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            Resource pdfFile = storageService.reworkExcelToPdf(file);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + pdfFile.getFilename() + "\"").body(pdfFile);
        } catch (Exception e) {
            throw new RuntimeException("Could not upload the file: " + file.getOriginalFilename()
                    + ". Error: " + e.getMessage(), e);
        }
    }
}
