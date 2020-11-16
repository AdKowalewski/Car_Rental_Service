package com.mappers;

import com.dto.CustomerDto;
import com.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toEntity(CustomerDto dto);

    CustomerDto toDto(Customer entity);
}
