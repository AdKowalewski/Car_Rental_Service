package com.mappers;

import com.dto.ReservationDto;
import com.model.Reservation;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-23T11:49:07+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public Reservation toEntity(ReservationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        reservation.setId( dto.getId() );
        reservation.setCustomer( dto.getCustomer() );
        reservation.setCar( dto.getCar() );
        reservation.setReceiptDate( dto.getReceiptDate() );
        reservation.setReturnDate( dto.getReturnDate() );
        reservation.setDepartmentFrom( dto.getDepartmentFrom() );
        reservation.setDepartmentTo( dto.getDepartmentTo() );
        reservation.setTotalCost( dto.getTotalCost() );

        return reservation;
    }

    @Override
    public ReservationDto toDto(Reservation entity) {
        if ( entity == null ) {
            return null;
        }

        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setId( entity.getId() );
        reservationDto.setCustomer( entity.getCustomer() );
        reservationDto.setCar( entity.getCar() );
        reservationDto.setReceiptDate( entity.getReceiptDate() );
        reservationDto.setReturnDate( entity.getReturnDate() );
        reservationDto.setDepartmentFrom( entity.getDepartmentFrom() );
        reservationDto.setDepartmentTo( entity.getDepartmentTo() );
        reservationDto.setTotalCost( entity.getTotalCost() );

        return reservationDto;
    }
}
