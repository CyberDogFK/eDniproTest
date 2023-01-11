package com.ednipro.dniprotesttask.service.mapper;

import com.ednipro.dniprotesttask.dto.CellModelResponseDto;
import com.ednipro.dniprotesttask.model.CellModel;
import org.springframework.stereotype.Service;

@Service
public class CellResponseMapper implements ResponseMapper<CellModel, CellModelResponseDto> {
    @Override
    public CellModelResponseDto mapToDto(CellModel model) {
        CellModelResponseDto cellDto = new CellModelResponseDto();
        cellDto.setValue(model.getValue());
        return cellDto;
    }
}
