package com.poli.serviceMovie.service;

import com.poli.serviceMovie.entities.Movie;
import com.poli.serviceMovie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}
