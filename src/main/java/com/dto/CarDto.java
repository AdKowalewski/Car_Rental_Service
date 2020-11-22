package com.dto;

import com.model.CarStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CarDto {

    private Long id;

    private String brand;

    private String model;

    private String bodyType;

    private Integer productionDate;

    private BigDecimal mileage;

    private String colour;

    private CarStatus status;

    private BigDecimal dailyFee;
}
