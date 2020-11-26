package com.mappers;

import com.dto.ReturnDto;
import com.model.Return;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-23T11:49:07+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
public class ReturnMapperImpl implements ReturnMapper {

    @Override
    public Return toEntity(ReturnDto dto) {
        if ( dto == null ) {
            return null;
        }

        Return return1 = new Return();

        return1.setId( dto.getId() );
        return1.setWorker( dto.getWorker() );
        return1.setReturnDate( dto.getReturnDate() );
        return1.setReservation( dto.getReservation() );
        return1.setSupplement( dto.getSupplement() );
        return1.setComments( dto.getComments() );

        return return1;
    }

    @Override
    public ReturnDto toDto(Return entity) {
        if ( entity == null ) {
            return null;
        }

        ReturnDto returnDto = new ReturnDto();

        returnDto.setId( entity.getId() );
        returnDto.setWorker( entity.getWorker() );
        returnDto.setReturnDate( entity.getReturnDate() );
        returnDto.setReservation( entity.getReservation() );
        returnDto.setSupplement( entity.getSupplement() );
        returnDto.setComments( entity.getComments() );

        return returnDto;
    }
}
