package com.dto;

import com.model.Department;
import com.model.Worker;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RentalOfficeDto {

    private Long rentalOfficeId;

    private String name;

    private String internetDomain;

    private String contactAddress;

    private Worker owner;

    private List<Department> departments;
}
