package com.mappers;

import com.dto.ReturnsDto;
import com.model.Returns;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReturnsMapper {

    ReturnsMapper INSTANCE = Mappers.getMapper(ReturnsMapper.class);

    Returns toEntity(ReturnsDto dto);

    ReturnsDto toDto(Returns entity);
}
