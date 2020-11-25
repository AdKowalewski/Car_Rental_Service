package com.mappers;

import com.dto.RentalCorpDto;
import com.model.RentalCorp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentalCorpMapper {

    RentalCorpMapper INSTANCE = Mappers.getMapper(RentalCorpMapper.class);

    RentalCorp toEntity(RentalCorpDto dto);

    RentalCorpDto toDto(RentalCorp entity);
}
