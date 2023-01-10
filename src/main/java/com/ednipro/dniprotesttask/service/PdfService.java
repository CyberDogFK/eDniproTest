package com.ednipro.dniprotesttask.service;

import com.ednipro.dniprotesttask.model.WorkbookModel;

public interface PdfService {
    String makePdfFromWorkbook(WorkbookModel workbookModel);
}
