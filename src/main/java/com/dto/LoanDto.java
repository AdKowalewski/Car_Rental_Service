package com.dto;

import com.model.Reservation;
import com.model.Worker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanDto {

    private Long loanId;

    private Worker worker;

    private String loanDate;

    private Reservation reservation;

    private String comments;
}
