package com.ednipro.dniprotesttask.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.ednipro.dniprotesttask.model.FileInfo;
import com.ednipro.dniprotesttask.model.ResponseMessage;
import com.ednipro.dniprotesttask.service.PdfService;
import com.ednipro.dniprotesttask.service.StorageService;
import com.ednipro.dniprotesttask.service.WorkbookService;
import com.ednipro.dniprotesttask.service.XlsFileReaderService;
import jakarta.annotation.PostConstruct;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    public ModelAndView listUploadedFiles() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("uploadForm");
        return modelAndView;
    }

    @PostMapping("/upload")
    @ResponseBody
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