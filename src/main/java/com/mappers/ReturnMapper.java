package com.mappers;

import com.dto.ReturnDto;
import com.model.Return;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReturnMapper {

    ReturnMapper INSTANCE = Mappers.getMapper(ReturnMapper.class);

    Return toEntity(ReturnDto dto);

    ReturnDto toDto(Return entity);
}
