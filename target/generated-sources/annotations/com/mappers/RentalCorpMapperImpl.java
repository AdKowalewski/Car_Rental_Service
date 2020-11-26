package com.mappers;

import com.dto.RentalCorpDto;
import com.model.Department;
import com.model.RentalCorp;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-23T11:49:07+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
public class RentalCorpMapperImpl implements RentalCorpMapper {

    @Override
    public RentalCorp toEntity(RentalCorpDto dto) {
        if ( dto == null ) {
            return null;
        }

        RentalCorp rentalCorp = new RentalCorp();

        rentalCorp.setId( dto.getId() );
        rentalCorp.setName( dto.getName() );
        rentalCorp.setInternetDomain( dto.getInternetDomain() );
        rentalCorp.setAddress( dto.getAddress() );
        List<Department> list = dto.getDepartments();
        if ( list != null ) {
            rentalCorp.setDepartments( new ArrayList<Department>( list ) );
        }

        return rentalCorp;
    }

    @Override
    public RentalCorpDto toDto(RentalCorp entity) {
        if ( entity == null ) {
            return null;
        }

        RentalCorpDto rentalCorpDto = new RentalCorpDto();

        rentalCorpDto.setId( entity.getId() );
        rentalCorpDto.setName( entity.getName() );
        rentalCorpDto.setInternetDomain( entity.getInternetDomain() );
        rentalCorpDto.setAddress( entity.getAddress() );
        List<Department> list = entity.getDepartments();
        if ( list != null ) {
            rentalCorpDto.setDepartments( new ArrayList<Department>( list ) );
        }

        return rentalCorpDto;
    }
}
