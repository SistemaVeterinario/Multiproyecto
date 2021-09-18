package com.poli.servicebooking;

import com.poli.serviceMovie.entities.Movie;
import com.poli.serviceMovie.repository.MovieRepository;
import com.poli.serviceMovie.service.MovieService;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Movie.class)
@RunWith(MockitoJUnitRunner.Silent.class)
public class ServiceMoviesApplicationTest {

    @Test
    void contextLoads() {
    }

    @Rule
    public ExpectedException exceptions = ExpectedException.none();

    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    MovieService movieService;

    @Mock
    MovieRepository movieRepository;

    @Test
    public void testShouldListMovies(){
        List<Movie> movies = new ArrayList<Movie>();
        getMovies(movies);
        Mockito.when(movieService.findAll()).thenReturn(movies);
        List<Movie> listMovies = movieService.findAll();
        Assertions.assertEquals(2, listMovies.size());
    }

    static List<Movie> getMovies(List<Movie> userMovies) {
        userMovies.add(new Movie(Long.valueOf(1),"Steven", 5, "RAPIDO Y FURIOSO"));
        userMovies.add(new Movie(Long.valueOf(2),"Brayan Miller", 1, "EL ULTIMO SUSPIRO"));
        return userMovies;
    }

}
