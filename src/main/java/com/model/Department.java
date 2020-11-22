package com.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "department")
public class Department extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String address;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Worker> workers;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Car> cars;
}
