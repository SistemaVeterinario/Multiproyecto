package com.poli.serviceMovie.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;


@Setter
@Getter
@Entity
@Table(name="movies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,nullable = false,unique = true)
    private Long id;

    @Column(name="director", nullable = false)
    private String director;

    @Column(name="rating" , nullable = false)
    private int rating;

    @Column(name="title" , nullable = false)
    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id.equals(movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
