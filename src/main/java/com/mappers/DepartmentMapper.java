package com.mappers;

import com.dto.DepartmentDto;
import com.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    Department toEntity(DepartmentDto dto);

    DepartmentDto toDto(Department entity);
}
