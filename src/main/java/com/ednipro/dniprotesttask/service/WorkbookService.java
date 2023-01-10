package com.ednipro.dniprotesttask.service;

import com.ednipro.dniprotesttask.model.WorkbookModel;

public interface WorkbookService {
    WorkbookModel getById(Long id);

    WorkbookModel save(WorkbookModel book);
}
