package com.mappers;

import com.dto.IncomeDto;
import com.model.Income;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-23T11:49:07+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
public class IncomeMapperImpl implements IncomeMapper {

    @Override
    public Income toEntity(IncomeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Income income = new Income();

        income.setId( dto.getId() );
        income.setIncomeValue( dto.getIncomeValue() );

        return income;
    }

    @Override
    public IncomeDto toDto(Income entity) {
        if ( entity == null ) {
            return null;
        }

        IncomeDto incomeDto = new IncomeDto();

        incomeDto.setId( entity.getId() );
        incomeDto.setIncomeValue( entity.getIncomeValue() );

        return incomeDto;
    }
}
