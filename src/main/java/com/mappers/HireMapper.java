package com.mappers;

import com.dto.HireDto;
import com.model.Hire;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HireMapper {

    HireMapper INSTANCE = Mappers.getMapper(HireMapper.class);

    Hire toEntity(HireDto dto);

    HireDto toDto(Hire entity);
}
