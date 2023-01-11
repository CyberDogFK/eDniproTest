package com.ednipro.dniprotesttask.controller;

import com.ednipro.dniprotesttask.dto.WorkbookModelResponseDto;
import com.ednipro.dniprotesttask.model.WorkbookModel;
import com.ednipro.dniprotesttask.service.PdfService;
import com.ednipro.dniprotesttask.service.StorageService;
import com.ednipro.dniprotesttask.service.WorkbookService;
import com.ednipro.dniprotesttask.service.mapper.ResponseMapper;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workbook")
public class WorkbookController {
    private final WorkbookService workbookService;
    private final PdfService pdfService;
    private final StorageService storageService;
    private final ResponseMapper<WorkbookModel, WorkbookModelResponseDto> workbookResponseMapper;

    public WorkbookController(WorkbookService workbookService,
                              PdfService pdfService,
                              StorageService storageService,
                              ResponseMapper<WorkbookModel,
                                      WorkbookModelResponseDto> workbookResponseMapper) {
        this.workbookService = workbookService;
        this.pdfService = pdfService;
        this.storageService = storageService;
        this.workbookResponseMapper = workbookResponseMapper;
    }

    @GetMapping("/{id}/history")
    @ApiOperation("Response list history of objects for workbook with requesting id")
    public List<WorkbookModelResponseDto> showHistoryOf(@PathVariable Long id) {
        return workbookService.getHistoryOf(id).stream()
                .map(workbookResponseMapper::mapToDto)
                .collect(Collectors.toList());
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
    public List<WorkbookModelResponseDto> findWith(@RequestParam String with) {
        return workbookService.getWithCell(with).stream()
                .map(workbookResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
