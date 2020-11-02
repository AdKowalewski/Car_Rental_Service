package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Returns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long returnsId;

    @Column(nullable = false)
    private Worker worker;

    @Column(nullable = false)
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    private int supplement;

    private String comments;
}
