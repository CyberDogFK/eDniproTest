package com.ednipro.dniprotesttask.service;

import com.ednipro.dniprotesttask.model.WorkbookModel;

public interface XlsFileReaderService {
    WorkbookModel saveWorkbookToDb(String file);
}
