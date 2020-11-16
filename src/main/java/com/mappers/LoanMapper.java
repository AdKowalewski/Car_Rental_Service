package com.mappers;

import com.dto.LoanDto;
import com.model.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    Loan toEntity(LoanDto dto);

    LoanDto toDto(Loan entity);
}
