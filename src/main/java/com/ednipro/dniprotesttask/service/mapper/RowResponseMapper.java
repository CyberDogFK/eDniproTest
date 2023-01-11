package com.ednipro.dniprotesttask.service.mapper;

import com.ednipro.dniprotesttask.dto.CellModelResponseDto;
import com.ednipro.dniprotesttask.dto.RowModelResponseDto;
import com.ednipro.dniprotesttask.model.CellModel;
import com.ednipro.dniprotesttask.model.RowModel;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class RowResponseMapper implements ResponseMapper<RowModel, RowModelResponseDto> {
    private final ResponseMapper<CellModel, CellModelResponseDto> cellResponseMapper;

    public RowResponseMapper(ResponseMapper<CellModel, CellModelResponseDto> cellResponseMapper) {
        this.cellResponseMapper = cellResponseMapper;
    }

    @Override
    public RowModelResponseDto mapToDto(RowModel model) {
        RowModelResponseDto rowDto = new RowModelResponseDto();
        rowDto.setListResponseDto(model.getCellModels().stream()
                .map(cellResponseMapper::mapToDto)
                .collect(Collectors.toList()));
        return rowDto;
    }
}
