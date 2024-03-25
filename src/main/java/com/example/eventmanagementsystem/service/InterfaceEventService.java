package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.dtos.PageResponse;
import com.example.eventmanagementsystem.models.Event;

import java.time.LocalDate;
import java.util.List;

public interface InterfaceEventService {
    public Event createEvent(Event event);

    //public List<Event> findAllEvents(double latitude, double longitude, LocalDate date);
    public PageResponse findAllEvents(double latitude, double longitude, LocalDate date, int pageNo, int pageSize);
    public List<Event> findEvents(LocalDate date);
    //public List<Event> getAllEvents(int pageNo, int pageSize);
    //public PageResponse getAllEvents(int pageNo, int pageSize);
    public PageResponse getAllEvents(int pageNo, int pageSize, String sortBy);


    List<Event> createAllEvents(List<Event> events);

}
