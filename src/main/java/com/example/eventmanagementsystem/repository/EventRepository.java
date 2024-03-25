package com.example.eventmanagementsystem.repository;

import com.example.eventmanagementsystem.models.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event save(Event event);

    List<Event> findAll();

   // List<EventResponseDto> findAllByDate(LocalDate date);

    //List<Event> findByLatitudeAndLongitudeAndDateBetween(double latitude, double longitude, LocalDate startDate, LocalDate endDate);

    Page<Event> findAllByLongitudeAfterAndLatitudeAfterAndDateBetweenOrderByDate(double latitude, double longitude, LocalDate startDate, LocalDate endDate, Pageable pageable);

    List<Event> findByDateBetween (LocalDate startDate, LocalDate endDate);
}
