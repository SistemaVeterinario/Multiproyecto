package com.poli.servicebooking.service;

import com.poli.servicebooking.entities.Showtime;

import java.util.List;

public interface ShowtimeService {
    void delete(Showtime showtime);
    void save(Showtime showtime);
    List<Showtime> findAll();
    Showtime findById(Long id);
}
