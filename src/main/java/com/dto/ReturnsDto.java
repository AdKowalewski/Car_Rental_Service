package com.dto;

import com.model.Reservation;
import com.model.Worker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnsDto {

    private Long returnsId;

    private Worker worker;

    private String returnDate;

    private Reservation reservation;

    private int supplement;

    private String comments;
}
