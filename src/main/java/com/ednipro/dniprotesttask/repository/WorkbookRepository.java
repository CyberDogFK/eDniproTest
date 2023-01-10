package com.ednipro.dniprotesttask.repository;

import com.ednipro.dniprotesttask.model.WorkbookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkbookRepository extends JpaRepository<WorkbookModel, Long> {
}
