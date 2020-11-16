package com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

    private Long carId;

    private String brand;

    private String model;

    private String bodyType;

    private int productionDate;

    private int mileage;

    private String colour;

    private String status;

    private int amountPerDayOfRental;
}
