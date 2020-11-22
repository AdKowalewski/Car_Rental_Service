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
public class WorkerJob extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Jobs name;

    public enum Jobs {
        WORKER, MANAGER
    }
}
