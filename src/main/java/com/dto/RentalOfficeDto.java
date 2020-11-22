package com.dto;

import com.model.Department;
import com.model.Worker;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RentalOfficeDto {

    private Long id;

    private String name;

    private String internetDomain;

    private String address;

    private Worker owner;

    private List<Department> departments;
}
