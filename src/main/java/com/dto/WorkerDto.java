package com.dto;

import com.model.Department;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class WorkerDto {

    private Long id;

    private String firstName;

    private String lastName;

    private LocalDateTime hireDate;

    private String job; //Worker or Manager

    private Department department;
}
