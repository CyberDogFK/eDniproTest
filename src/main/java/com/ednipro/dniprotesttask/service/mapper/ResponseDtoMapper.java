package com.ednipro.dniprotesttask.service.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
