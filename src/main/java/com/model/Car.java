package com.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "car")
public class Car extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String brand;

    @Column(length = 50, nullable = false)
    private String model;

    @Column(length = 50, nullable = false)
    private String bodyType;

    @Column(nullable = false)
    private Integer productionDate;

    @Column(nullable = false)
    private BigDecimal mileage;

    @Column(length = 50, nullable = false)
    private String colour;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private CarStatus status;

    @Column(nullable = false)
    private BigDecimal dailyFee;
}
