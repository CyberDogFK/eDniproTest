package com.ednipro.dniprotesttask.repository;

import com.ednipro.dniprotesttask.model.WorkbookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkbookRepository extends JpaRepository<WorkbookModel, Long> {
    @Query("select wm from WorkbookModel wm join wm.sheetModels sm "
            + "join sm.rowModels rm "
            + "join rm.cellModels cm "
            + "where cm.value = ?1")
    List<WorkbookModel> findByCell(String info);
}
