package com.ednipro.dniprotesttask.repository;

import com.ednipro.dniprotesttask.model.WorkbookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkbookRepository extends JpaRepository<WorkbookModel, Long> {
    Optional<WorkbookModel> findByName(String name);
}
