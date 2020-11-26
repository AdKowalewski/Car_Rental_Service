package com.mappers;

import com.dto.CustomerDto;
import com.model.Customer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-23T11:49:07+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( dto.getId() );
        customer.setFirstName( dto.getFirstName() );
        customer.setLastName( dto.getLastName() );
        customer.setEmail( dto.getEmail() );
        customer.setAddress( dto.getAddress() );

        return customer;
    }

    @Override
    public CustomerDto toDto(Customer entity) {
        if ( entity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( entity.getId() );
        customerDto.setFirstName( entity.getFirstName() );
        customerDto.setLastName( entity.getLastName() );
        customerDto.setEmail( entity.getEmail() );
        customerDto.setAddress( entity.getAddress() );

        return customerDto;
    }
}
