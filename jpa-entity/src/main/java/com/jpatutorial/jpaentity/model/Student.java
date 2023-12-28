package com.jpatutorial.jpaentity.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.CascadeType;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "student")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NoArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    private int age;
    @Column(name = "birth_date")
    private Date birthDate;

    // Relacion OneToOne con Student
    // Un estudiante tiene una informacion de contacto, y una informacion de contacto pertenece a un estudiante
    // Metodo 1: Crear un campo extra en ContactInfo con la relacion foranea
    // Se crea el campo student_id en la tabla contact_info
//    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, optional = false)
//    private ContactInfo contactInfo;

    // Metodo 2: La llave foreanea para a ser la llave primaria de ContactInfo
//    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @JsonIgnoreProperties("student")
//    private ContactInfo contactInfo;

    // Relacion ManyToMany con Course
    // Un estudiante puede tener muchos cursos, y un curso puede tener muchos estudiantes
    // Metodo 1: Crear una tabla intermedia
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonIgnoreProperties("students")
    private Set<Course> courses;

    public Student(String name, Set<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public Student(String name) {
        this.name = name;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }

//    public Set<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }
}
