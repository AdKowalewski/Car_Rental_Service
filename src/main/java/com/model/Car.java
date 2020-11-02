package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(length = 50, nullable = false)
    private String brand;

    @Column(length = 50, nullable = false)
    private String model;

    @Column(length = 50, nullable = false)
    private String bodyType;

    @Column(nullable = false)
    private int productionDate;

    @Column(nullable = false)
    private int mileage;

    @Column(length = 50, nullable = false)
    private String colour;

    @Column(length = 50, nullable = false)
    private String status;

    @Column(nullable = false)
    private int amountPerDayOfRental;
}
