package com.poli.serviceshowtimes.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movie {
    private Long id;
    private String director;
    private int rating;
    private String title;

}
