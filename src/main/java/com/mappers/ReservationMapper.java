package com.mappers;

import com.dto.ReservationDto;
import com.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    Reservation toEntity(ReservationDto dto);

    ReservationDto toDto(Reservation entity);
}
