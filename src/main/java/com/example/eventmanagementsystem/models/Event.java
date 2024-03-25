package com.example.eventmanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@Entity

public class Event extends BaseModel{
    @Column(name = "event_name")
    private String event_name;
    @Column(name = "city_name")
    private String city_name;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "time")
    private LocalTime time;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;



}
