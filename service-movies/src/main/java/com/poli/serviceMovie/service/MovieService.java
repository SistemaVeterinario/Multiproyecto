package com.poli.serviceMovie.service;

import com.poli.serviceMovie.entities.Movie;

import java.util.List;

public interface MovieService {
    void delete(Movie booking);
    void save(Movie booking);
    List<Movie> findAll();
    Movie findById(Long id);
}
