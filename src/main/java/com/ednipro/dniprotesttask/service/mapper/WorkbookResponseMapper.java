package com.ednipro.dniprotesttask.service.mapper;

import com.ednipro.dniprotesttask.dto.SheetModelResponseDto;
import com.ednipro.dniprotesttask.dto.WorkbookModelResponseDto;
import com.ednipro.dniprotesttask.model.SheetModel;
import com.ednipro.dniprotesttask.model.WorkbookModel;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class WorkbookResponseMapper
        implements ResponseMapper<WorkbookModel, WorkbookModelResponseDto> {
    private final ResponseMapper<SheetModel, SheetModelResponseDto> sheetResponseMapper;

    public WorkbookResponseMapper(ResponseMapper<SheetModel,
                    SheetModelResponseDto> sheetResponseMapper) {
        this.sheetResponseMapper = sheetResponseMapper;
    }

    @Override
    public WorkbookModelResponseDto mapToDto(WorkbookModel model) {
        WorkbookModelResponseDto dto = new WorkbookModelResponseDto();
        dto.setListSheetModelResponseDto(model.getSheetModels().stream()
                .map(sheetResponseMapper::mapToDto)
                .collect(Collectors.toList()));
        dto.setSavingDateTime(model.getSavingDateTime());
        return dto;
    }
}
