package com.ednipro.dniprotesttask.service;

import com.ednipro.dniprotesttask.model.WorkbookModel;

import java.util.Optional;

public interface WorkbookService {
    WorkbookModel getById(Long id);

    WorkbookModel save(WorkbookModel book);
}
