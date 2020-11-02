package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Column(length = 50, nullable = false)
    private String reservationDate;

    @Column(nullable = false)
    private Customer customer;

    @Column(length = 50, nullable = false)
    private String dateFrom;

    @Column(length = 50, nullable = false)
    private String dateTo;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department departmentFrom;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department departmentTo;

    @Column(nullable = false)
    private int amount;
}
