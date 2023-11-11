package com.example.EE25FinalProjectEventAggregatorService.events.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedEvent {
    private String name;
    private String eventStart;
    private String eventDuration;
    private String address;
    private String description;
}