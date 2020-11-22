package com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "reservation")
public class Reservation extends BaseEntity {

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Customer customer;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Car car;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "receiptDate")
    private Timestamp receiptDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "returnDate")
    private Timestamp returnDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department departmentFrom;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department departmentTo;

    @Column(nullable = false)
    private BigDecimal totalCost;
}
