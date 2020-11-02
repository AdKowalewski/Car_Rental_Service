package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(length = 100, nullable = false)
    private String address;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Worker> workers;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Car> cars;
}
