package com.poli.servicebooking;

import com.poli.serviceshowtimes.entities.Showtime;
import com.poli.serviceshowtimes.model.Movie;
import com.poli.serviceshowtimes.service.ShowtimeService;
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
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = Showtime.class)
@RunWith(MockitoJUnitRunner.Silent.class)
class ServiceShowtimesApplicationTests {

    @Test
    void contextLoads() {
    }

}
