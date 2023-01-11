package com.ednipro.dniprotesttask.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkbookModelResponseDto {
    private List<SheetModelResponseDto> listSheetModelResponseDto;
    private LocalDateTime savingDateTime;
}
