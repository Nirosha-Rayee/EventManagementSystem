package com.example.eventmanagementsystem.service;

import com.example.eventmanagementsystem.dtos.EventResponseDto;
import com.example.eventmanagementsystem.dtos.PageResponse;
import com.example.eventmanagementsystem.models.Event;
import com.example.eventmanagementsystem.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class EventService implements InterfaceEventService {

    @Autowired
    private  EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);

    }

//    @Override
//    public List<Event> findAllEvents(double latitude, double longitude, LocalDate date) {
//        //mention start date is the current date and end date is 14 days from the current date
//        LocalDate startDate = date;
//       LocalDate endDate = date.plusDays(14);
//
//       //return eventRepository.findByLatitudeAndLongitudeAndDateBetween(latitude, longitude, startDate, endDate);
//
////        RestTemplate restTemplate = new RestTemplate();
////        ResponseEntity<WeatherResponse> weatherResponse = restTemplate.getForEntity("http://localhost:9000/api/v1/waether/", WeatherResponse.class);
//
//
//        return eventRepository.findAllByLongitudeAfterAndLatitudeAfterAndDateBetweenOrderByDate(latitude, longitude, startDate, endDate);
//    }


    @Override
    public List<Event> findEvents(LocalDate date) {
        //mention start date is the current date and end date is 14 days from the current date
        LocalDate startDate = date;
        LocalDate endDate = date.plusDays(14);
        return eventRepository.findByDateBetween(startDate, endDate);
}


    @Override
    public PageResponse getAllEvents(int pageNo, int pageSize, String sortBy) { //changed List<Event> to PageResponse return type
        //pagination logic
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Event> page = eventRepository.findAll(pageable);


        //get content for the page object
        List<Event> events = page.getContent();

//        //List<EventRequestDto> content = page.getContent().stream().map(event -> {
//            EventRequestDto eventRequestDto = new EventRequestDto();
//            eventRequestDto.setEvent_name(event.getEvent_name());
//            eventRequestDto.setCity_name(event.getCity_name());
//            eventRequestDto.setLatitude(event.getLatitude());
//            eventRequestDto.setLongitude(event.getLongitude());
//            eventRequestDto.setDate(event.getDate());
//            eventRequestDto.setTime(event.getTime());
//            return eventRequestDto;
//        }).collect(Collectors.toList());

        List<EventResponseDto> content = page.getContent().stream().map(event -> {
            EventResponseDto eventResponseDto = new EventResponseDto();
            eventResponseDto.setEvent_name(event.getEvent_name());
            eventResponseDto.setCity_name(event.getCity_name());
            eventResponseDto.setDate(event.getDate());
            return eventResponseDto;
                }).collect(Collectors.toList());


        PageResponse pageResponse = new PageResponse();
        pageResponse.setEvents(content);
        pageResponse.setPage(page.getNumber()+1);
        pageResponse.setPageSize(page.getSize());
        pageResponse.setTotalEvents(page.getTotalElements());
        pageResponse.setTotalPages(page.getTotalPages());



        return pageResponse;

       // return eventRepository.findAll();
    }

    @Override
    public List<Event> createAllEvents(List<Event> events) {
        return eventRepository.saveAll(events);
    }


    @Override
    public PageResponse findAllEvents(double latitude, double longitude, LocalDate date, int page, int pageSize) {

        LocalDate startDate = date;
        LocalDate endDate = date.plusDays(14);

        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Event> page1 = eventRepository.findAllByLongitudeAfterAndLatitudeAfterAndDateBetweenOrderByDate(latitude, longitude, startDate, endDate, pageable);


        //get content for the page object
        List<Event> events = page1.getContent();

        List<EventResponseDto> content = page1.getContent().stream().map(event -> {
            EventResponseDto eventResponseDto = new EventResponseDto();
            eventResponseDto.setEvent_name(event.getEvent_name());
            eventResponseDto.setCity_name(event.getCity_name());
            eventResponseDto.setDate(event.getDate());
            return eventResponseDto;
        }).collect(Collectors.toList());

        PageResponse pageResponse = new PageResponse();
        pageResponse.setEvents(content);
        pageResponse.setPage(page1.getNumber()+1);
        pageResponse.setPageSize(page1.getSize());
        pageResponse.setTotalEvents(page1.getTotalElements());
        pageResponse.setTotalPages(page1.getTotalPages());



        return pageResponse;

    }


}
