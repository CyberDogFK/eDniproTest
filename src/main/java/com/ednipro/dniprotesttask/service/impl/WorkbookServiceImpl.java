package com.ednipro.dniprotesttask.service.impl;

import com.ednipro.dniprotesttask.model.WorkbookModel;
import com.ednipro.dniprotesttask.repository.WorkbookRepository;
import com.ednipro.dniprotesttask.service.WorkbookService;
import org.apache.poi.sl.draw.geom.GuideIf;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkbookServiceImpl implements WorkbookService {
    private final WorkbookRepository workbookRepository;

    public WorkbookServiceImpl(WorkbookRepository workbookRepository) {
        this.workbookRepository = workbookRepository;
    }

    @Override
    public WorkbookModel getById(Long id) {
        return workbookRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't find table with id " + id));
    }

    @Override
    public WorkbookModel save(WorkbookModel book) {
        return workbookRepository.save(book);
    }
}
