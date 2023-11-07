package com.example.EE25FinalProjectEventAggregatorService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "event_start")
    private String eventStart;
    @Column(name = "event_duration")
    private String eventDuration;
    @Column(name = "address")
    private String address;
    @Column(name = "description")
    private String description;
}
