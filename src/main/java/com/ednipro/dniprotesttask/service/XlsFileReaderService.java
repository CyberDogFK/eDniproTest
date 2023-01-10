package com.ednipro.dniprotesttask.service;

import com.ednipro.dniprotesttask.model.WorkbookModel;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface XlsFileReaderService {
    WorkbookModel saveWorkbookToDb(String file);
}
