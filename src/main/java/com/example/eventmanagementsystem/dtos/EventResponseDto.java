package com.example.eventmanagementsystem.dtos;

import com.example.eventmanagementsystem.models.WeatherResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class EventResponseDto {
    private String event_name;
    private String city_name;
    private LocalDate date;

    private WeatherResponse weather;



}
