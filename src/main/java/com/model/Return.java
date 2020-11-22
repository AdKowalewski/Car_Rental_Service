package com.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "return")
public class Return extends BaseEntity {

    @OneToOne(mappedBy = "return", cascade = CascadeType.ALL, orphanRemoval = true)
    private Worker worker;

    @Column(nullable = false)
    private String returnDate;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    private BigDecimal supplement;

    private String comments;
}
