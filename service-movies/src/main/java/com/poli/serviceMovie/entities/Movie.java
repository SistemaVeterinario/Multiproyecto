package com.poli.serviceMovie.entities;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
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

    @NotEmpty(message = "El nombre  no debe estar en blanco")
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
