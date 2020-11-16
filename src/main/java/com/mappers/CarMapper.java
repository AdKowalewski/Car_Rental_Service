package com.mappers;

import com.dto.CarDto;
import com.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    Car toEntity(CarDto dto);

    CarDto toDto(Car entity);
}
