package com.poli.servicebooking.service;

import com.poli.servicebooking.entities.Booking;

import java.util.List;

public interface  BookingService {
    void delete(Booking booking);
    void save(Booking booking);
    List<Booking> findAll();
    Booking findById(Long id);
}
