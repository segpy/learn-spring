package com.jpatutorial.jpaentity.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "course")
//@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course implements Serializable {
    public Course() {

    }

    public Course(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    // Relacion OneToMany/ManyToOne con la tabla Instructor
    // Un curso tiene un instructor, y un instructor puede tener muchos cursos
    // instructor [1] -> [N][PK] courses
    // Metodo 2: Bidireccional
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonIgnoreProperties("courses")
//    private Instructor instructor;

    // Relacion ManyToMany con Student
    // Un estudiante puede tener muchos cursos, y un curso puede tener muchos estudiantes
    // Metodo 1: Crear una tabla intermedia
    @ManyToMany(mappedBy = "courses")
//    @JsonIgnoreProperties("courses")
    private Set<Student> students;


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
