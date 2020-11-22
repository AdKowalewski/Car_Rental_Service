package com.dto;

import com.model.Car;
import com.model.Worker;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DepartmentDto {

    private Long id;

    private String address;

    private List<Worker> workers;

    private List<Car> cars;
}
