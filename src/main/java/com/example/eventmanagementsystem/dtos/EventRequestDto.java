package com.example.eventmanagementsystem.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
public class EventRequestDto {
    private String event_name;
    private String city_name;
    private LocalDate date;
    private LocalTime time;
    private double latitude;
    private double longitude;
}
