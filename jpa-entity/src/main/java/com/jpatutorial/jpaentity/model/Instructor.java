package com.jpatutorial.jpaentity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.CascadeType;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "instructor")
@NoArgsConstructor
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    // Relacion OneToMany con la tabla Course
    // Un curso tiene un instructor, y un instructor puede tener muchos cursos
    // instructor [1] -> [N][PK] courses

    // Metodo 1: Unidireccional (no recomendada, ya que crea una tabla intermedia)
    // @OneToMany
    // private Set<Course> courses = new HashSet<>();

    // Metodo 2: Bidireccional
    // mappedBy: se usa en la clase que no tiene la FK
//    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("instructor")
//    private Set<Course> courses = new HashSet<>();
}
