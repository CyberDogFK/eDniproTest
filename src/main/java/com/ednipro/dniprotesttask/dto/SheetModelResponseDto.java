package com.ednipro.dniprotesttask.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SheetModelResponseDto {
    private List<RowModelResponseDto> listRowResponseDto;
}
