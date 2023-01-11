package com.ednipro.dniprotesttask.service;

import com.ednipro.dniprotesttask.model.WorkbookModel;
import java.util.List;

public interface WorkbookService {
    WorkbookModel getById(Long id);

    WorkbookModel save(WorkbookModel book);

    List<WorkbookModel> getWithCell(String info);

    List<WorkbookModel> getHistoryOf(Long id);
}
