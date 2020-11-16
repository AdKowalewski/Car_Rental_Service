package com.mappers;

import com.dto.IncomeDto;
import com.model.Income;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IncomeMapper {

    IncomeMapper INSTANCE = Mappers.getMapper(IncomeMapper.class);

    Income toEntity(IncomeDto dto);

    IncomeDto toDto(Income entity);
}
