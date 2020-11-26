package com.mappers;

import com.dto.CarDto;
import com.model.Car;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-11-23T11:49:07+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.6 (AdoptOpenJDK)"
)
public class CarMapperImpl implements CarMapper {

    @Override
    public Car toEntity(CarDto dto) {
        if ( dto == null ) {
            return null;
        }

        Car car = new Car();

        car.setId( dto.getId() );
        car.setBrand( dto.getBrand() );
        car.setModel( dto.getModel() );
        car.setBodyType( dto.getBodyType() );
        car.setProductionDate( dto.getProductionDate() );
        car.setMileage( dto.getMileage() );
        car.setColour( dto.getColour() );
        car.setStatus( dto.getStatus() );
        car.setDailyFee( dto.getDailyFee() );

        return car;
    }

    @Override
    public CarDto toDto(Car entity) {
        if ( entity == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setId( entity.getId() );
        carDto.setBrand( entity.getBrand() );
        carDto.setModel( entity.getModel() );
        carDto.setBodyType( entity.getBodyType() );
        carDto.setProductionDate( entity.getProductionDate() );
        carDto.setMileage( entity.getMileage() );
        carDto.setColour( entity.getColour() );
        carDto.setStatus( entity.getStatus() );
        carDto.setDailyFee( entity.getDailyFee() );

        return carDto;
    }
}
