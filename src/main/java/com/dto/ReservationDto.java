package com.dto;

import com.model.Customer;
import com.model.Department;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDto {

    private Long reservationId;

    private String reservationDate;

    private Customer customer;

    private String dateFrom;

    private String dateTo;

    private Department departmentFrom;

    private Department departmentTo;

    private int amount;
}
