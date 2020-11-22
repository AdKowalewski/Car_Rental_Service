package com.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "worker")
public class Worker extends BaseEntity {

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDateTime hireDate;

    @OneToOne(mappedBy = "worker", cascade = CascadeType.ALL, orphanRemoval = true)
    private WorkerJob job; //Worker or Manager

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
