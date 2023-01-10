package com.ednipro.dniprotesttask.controller;

import com.ednipro.dniprotesttask.model.WorkbookModel;
import com.ednipro.dniprotesttask.service.PdfService;
import com.ednipro.dniprotesttask.service.StorageService;
import com.ednipro.dniprotesttask.service.WorkbookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workbook")
public class WorkbookController {
    private final WorkbookService workbookService;
    private final PdfService pdfService;
    private final StorageService storageService;

    public WorkbookController(WorkbookService workbookService, PdfService pdfService, StorageService storageService) {
        this.workbookService = workbookService;
        this.pdfService = pdfService;
        this.storageService = storageService;
    }

    @GetMapping("/{id}")
    @ApiOperation("Download pdf file of table with id")
    public ResponseEntity<Resource> getPdfOf(@PathVariable Long id) {
        WorkbookModel byId = workbookService.getById(id);
        String pdfFromWorkbook = pdfService.makePdfFromWorkbook(byId);
        Resource pdfFile = storageService.load(pdfFromWorkbook);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + pdfFile.getFilename() + "\"").body(pdfFile);
    }

    @GetMapping
    @ApiOperation("Give json file with all finded workbooks with looking information")
    public List<WorkbookModel> findWith(@RequestParam String with) {
        List<WorkbookModel> withCell = workbookService.getWithCell(with);
        if (withCell.isEmpty()) {
            throw new RuntimeException("No table with cell " + with);
        }
        return withCell;
    }
}
