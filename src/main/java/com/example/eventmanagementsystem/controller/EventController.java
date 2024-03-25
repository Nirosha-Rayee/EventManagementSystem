package com.example.eventmanagementsystem.controller;

import com.example.eventmanagementsystem.dtos.EventRequestDto;
import com.example.eventmanagementsystem.dtos.EventResponseDto;
import com.example.eventmanagementsystem.dtos.PageResponse;
import com.example.eventmanagementsystem.models.Event;
import com.example.eventmanagementsystem.service.InterfaceEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
   @Autowired
    InterfaceEventService interfaceEventService;

   public EventController(InterfaceEventService interfaceEventService) {
        this.interfaceEventService = interfaceEventService;
   }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody EventRequestDto eventRequestDto){
        Event event = getEvent(eventRequestDto);
        Event event1 = interfaceEventService.createEvent(event);
        return ResponseEntity.ok(event1);
    }

    /*public ResponseEntity<Event> createEvent(@RequestBody Event event){

        Event event1 = interfaceEventService.createEvent(event);
        return ResponseEntity.ok(event1);
    }*/ // becoz, we should not expose the model class to the client, so we use DTO

//    @GetMapping("/find")
//    public ResponseEntity<List<Event>> findAllEvents(@RequestParam double latitude, @RequestParam double longitude, @RequestParam LocalDate date) {
//        List<Event> events = interfaceEventService.findAllEvents(latitude, longitude, date);
//        return ResponseEntity.ok(events);
//       // return ResponseEntity.ok(interfaceEventService.getAllEvents(pageNo, pageSize, sortBy));
//    }

//    @GetMapping("/find")
//    public ResponseEntity<List<EventResponseDto>> findAllEvents(@RequestParam double latitude, @RequestParam double longitude, @RequestParam LocalDate date,
//                                                                @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
//                                                                @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
//
//        List<Event> events = interfaceEventService.findAllEvents(latitude, longitude, date, pageNo, pageSize);
//        List<EventResponseDto> eventResponseDtos = events.stream().map(event -> {
//            EventResponseDto eventResponseDto = new EventResponseDto();
//            eventResponseDto.setEvent_name(event.getEvent_name());
//            eventResponseDto.setCity_name(event.getCity_name());
//            eventResponseDto.setDate(event.getDate());
//            return eventResponseDto;
//        }).collect(java.util.stream.Collectors.toList());
//
//
//        return ResponseEntity.ok(eventResponseDtos);
//
//
//
//    }
//

    @GetMapping("/findByDate")
    public ResponseEntity<List<Event>> findEvents(@RequestParam LocalDate date) {
        List<Event> events = interfaceEventService.findEvents(date);
        return ResponseEntity.ok(events);
    }


    @GetMapping("/all") //changed return type from List<Event> to PageResponse
    public ResponseEntity <PageResponse> getAllProducts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy



    ){
        return ResponseEntity.ok(interfaceEventService.getAllEvents(pageNo, pageSize, sortBy));

    }

    //conversion logic from DTO to Model
    private Event getEvent(EventRequestDto eventRequestDto){
        Event event = new Event();
        event.setEvent_name(eventRequestDto.getEvent_name());
        event.setCity_name(eventRequestDto.getCity_name());
        event.setDate(eventRequestDto.getDate());
        event.setTime(eventRequestDto.getTime());
        event.setLatitude(eventRequestDto.getLatitude());
        event.setLongitude(eventRequestDto.getLongitude());
        return event;
    }



    @GetMapping("/find")
    public ResponseEntity<PageResponse> findAllEvents(@RequestParam double latitude, @RequestParam double longitude, @RequestParam LocalDate date,
                                                                @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                                @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {

        return  ResponseEntity.ok(interfaceEventService.findAllEvents(latitude, longitude, date, pageNo, pageSize));

    }



    //create a list of events in the database using postman

    @PostMapping("/createAll")
    public ResponseEntity<List<Event>> createEvent(@RequestBody List<EventRequestDto> eventRequestDto){
        List<Event> events = eventRequestDto.stream().map(eventRequestDto1 -> {
            return getEvent(eventRequestDto1);
        }).collect(java.util.stream.Collectors.toList());

        List<Event> events1 = interfaceEventService.createAllEvents(events);
        return ResponseEntity.ok(events1);
    }



}








