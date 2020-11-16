package com.mappers;

import com.dto.WorkerDto;
import com.model.Worker;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkerMapper {

    WorkerMapper INSTANCE = Mappers.getMapper(WorkerMapper.class);

    Worker toEntity(WorkerDto dto);

    WorkerDto toDto(Worker entity);
}
