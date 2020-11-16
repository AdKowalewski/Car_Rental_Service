package com.mappers;

import com.dto.RentalOfficeDto;
import com.model.RentalOffice;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentalOfficeMapper {

    RentalOfficeMapper INSTANCE = Mappers.getMapper(RentalOfficeMapper.class);

    RentalOffice toEntity(RentalOfficeDto dto);

    RentalOfficeDto toDto(RentalOffice entity);
}
