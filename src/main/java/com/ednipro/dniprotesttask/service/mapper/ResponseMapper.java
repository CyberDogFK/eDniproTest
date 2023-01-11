package com.ednipro.dniprotesttask.service.mapper;

public interface ResponseMapper<T, D> {
    D mapToDto(T model);
}
