package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column(nullable = false)
    private Worker worker;

    @Column(nullable = false)
    private String loanDate;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    private String comments;
}
