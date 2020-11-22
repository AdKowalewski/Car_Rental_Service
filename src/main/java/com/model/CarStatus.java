package com.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Entity
public class CarStatus extends BaseEntity {

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarStatuses name;

    public enum CarStatuses {
        BORROWED, AVAILABLE, UNAVAILABLE
    }
}
