package com.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "rental_office")
public class RentalCorp extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String internetDomain;

    @Column(length = 100, nullable = false)
    private String address;

//    @Column(nullable = false)
//    private Worker owner;

    @OneToMany(mappedBy = "rental_office", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Department> departments;
}
