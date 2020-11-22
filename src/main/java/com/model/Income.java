package com.model;

import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Income extends BaseEntity {

    private BigDecimal incomeValue;
}
