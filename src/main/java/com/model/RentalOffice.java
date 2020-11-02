package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "rental_office")
public class RentalOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalOfficeId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String internetDomain;

    @Column(length = 100, nullable = false)
    private String contactAddress;

    @Column(nullable = false)
    private Worker owner;

    @OneToMany(mappedBy = "rental_office", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Department> departments;
}
