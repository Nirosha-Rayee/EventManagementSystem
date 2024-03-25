package com.example.eventmanagementsystem.dtos;

import com.example.eventmanagementsystem.models.Event;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResponse {
    //private List<EventRequestDto> events;
    private List<EventResponseDto> events;
    private int page;
    private int pageSize;
    private long totalEvents;
    private int totalPages;



}
