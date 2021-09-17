package com.poli.serviceMovie.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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


    @NotEmpty(message = "El director no debe estar en blanco")
    @Column(name="director", nullable = false)
    private String director;


    @Min(value = 1, message = "Debe ser minimo 1")
    @Max(value = 5, message = "Debe ser maximo 5")
    @Column(name="rating" , nullable = false)
    private int rating;

    @NotEmpty(message = "El titulo  no debe estar en blanco")
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
