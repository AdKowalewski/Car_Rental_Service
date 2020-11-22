package com.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class IncomeDto {

    private Long id;

    private BigDecimal incomeValue;
}
