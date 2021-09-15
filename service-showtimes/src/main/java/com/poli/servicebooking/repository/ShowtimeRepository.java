package com.poli.servicebooking.repository;

import com.poli.servicebooking.entities.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
}
