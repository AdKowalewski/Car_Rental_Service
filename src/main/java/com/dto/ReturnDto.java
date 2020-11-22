package com.dto;

import com.model.Reservation;
import com.model.Worker;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ReturnDto {

    private Long id;

    private Worker worker;

    private String returnDate;

    private Reservation reservation;

    private BigDecimal supplement;

    private String comments;
}
