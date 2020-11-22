package com.mappers;

import com.dto.ReturnsDto;
import com.model.Return;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReturnsMapper {

    ReturnsMapper INSTANCE = Mappers.getMapper(ReturnsMapper.class);

    Return toEntity(ReturnsDto dto);

    ReturnsDto toDto(Return entity);
}
