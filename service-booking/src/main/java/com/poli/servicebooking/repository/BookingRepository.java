package com.poli.servicebooking.repository;

import com.poli.servicebooking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Long> {
}
