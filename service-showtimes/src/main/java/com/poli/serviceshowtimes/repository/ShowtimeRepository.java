package com.poli.serviceshowtimes.repository;

import com.poli.serviceshowtimes.entities.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
}
