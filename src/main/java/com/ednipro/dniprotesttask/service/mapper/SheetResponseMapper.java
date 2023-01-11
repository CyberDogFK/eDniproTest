package com.ednipro.dniprotesttask.service.mapper;

import com.ednipro.dniprotesttask.dto.RowModelResponseDto;
import com.ednipro.dniprotesttask.dto.SheetModelResponseDto;
import com.ednipro.dniprotesttask.model.RowModel;
import com.ednipro.dniprotesttask.model.SheetModel;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SheetResponseMapper implements ResponseMapper<SheetModel, SheetModelResponseDto> {
    private final ResponseMapper<RowModel, RowModelResponseDto> rowMapper;

    public SheetResponseMapper(ResponseMapper<RowModel, RowModelResponseDto> rowMapper) {
        this.rowMapper = rowMapper;
    }

    @Override
    public SheetModelResponseDto mapToDto(SheetModel model) {
        SheetModelResponseDto sheetDto = new SheetModelResponseDto();
        sheetDto.setListRowResponseDto(model.getRowModels().stream()
                .map(rowMapper::mapToDto)
                .collect(Collectors.toList()));
        return sheetDto;
    }
}
