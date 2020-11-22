package com.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "hire")
public class Hire extends BaseEntity {

    @OneToOne(mappedBy = "hire", cascade = CascadeType.ALL, orphanRemoval = true)
    private Worker worker;

    @Column(nullable = false)
    private String hireDate;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    private String comments;
}
