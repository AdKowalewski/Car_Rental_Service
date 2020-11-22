package com.dto;

import com.model.Reservation;
import com.model.Worker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HireDto {

    private Long id;

    private Worker worker;

    private String hireDate;

    private Reservation reservation;

    private String comments;
}
