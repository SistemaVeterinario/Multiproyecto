package com.poli.serviceuser.entities;
import javax.validation.constraints.NotEmpty;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotEmpty(message = "El nombre no debe ser vacio")
    @Column(name="name" , nullable = false)
    private String name;

    @NotEmpty(message = "El apellido no debe ser vacio")
    @Column(name="lastname", nullable = false)
    private String lastname;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
