package com.jpatutorial.jpaentity.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact_info")
@NoArgsConstructor
public class ContactInfo {

    // Metodo 1
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    // Metodo 2
    @Id
    @Column(name = "student_id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "state", nullable = false)
    private String state;
    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    // Relacion OneToOne con Student
    // Metodo 1: Crear un campo extra en ContactInfo con la relacion foranea
    // Se crea el campo student_id en la tabla contact_info
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "student_id")
    private Student student;

    // Metodo 2: La llave foreanea para a ser la llave primaria de ContactInfo
//    @OneToOne(cascade = CascadeType.ALL, optional = false)
//    @MapsId
//    @JoinColumn(name = "student_id")
//    @JsonIgnoreProperties("contactInfo")
//    private Student student;

}
