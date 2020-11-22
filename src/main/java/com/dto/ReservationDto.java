package com.dto;

import com.model.Car;
import com.model.Customer;
import com.model.Department;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class ReservationDto {

    private Long id;

    private Customer customer;

    private Car car;

    private Timestamp receiptDate;

    private Timestamp returnDate;

    private Department departmentFrom;

    private Department departmentTo;

    private BigDecimal totalCost;
}
