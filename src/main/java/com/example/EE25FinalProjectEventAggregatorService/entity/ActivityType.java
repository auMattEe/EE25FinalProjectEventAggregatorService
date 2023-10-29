package com.example.EE25FinalProjectEventAggregatorService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "activity_type")
public class ActivityType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
}
