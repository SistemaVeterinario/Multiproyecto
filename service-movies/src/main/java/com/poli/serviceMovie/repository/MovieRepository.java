package com.poli.serviceMovie.repository;

import com.poli.serviceMovie.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {
}
