package com.mappers;

import com.dto.HireDto;
import com.model.Hire;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-23T11:49:07+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
public class HireMapperImpl implements HireMapper {

    @Override
    public Hire toEntity(HireDto dto) {
        if ( dto == null ) {
            return null;
        }

        Hire hire = new Hire();

        hire.setId( dto.getId() );
        hire.setWorker( dto.getWorker() );
        hire.setHireDate( dto.getHireDate() );
        hire.setReservation( dto.getReservation() );
        hire.setComments( dto.getComments() );

        return hire;
    }

    @Override
    public HireDto toDto(Hire entity) {
        if ( entity == null ) {
            return null;
        }

        HireDto hireDto = new HireDto();

        hireDto.setId( entity.getId() );
        hireDto.setWorker( entity.getWorker() );
        hireDto.setHireDate( entity.getHireDate() );
        hireDto.setReservation( entity.getReservation() );
        hireDto.setComments( entity.getComments() );

        return hireDto;
    }
}
