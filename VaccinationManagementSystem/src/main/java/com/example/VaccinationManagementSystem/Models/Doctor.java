package com.example.VaccinationManagementSystem.Models;

import com.example.VaccinationManagementSystem.Enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "doctors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(unique = true)
    private String emailId;

    private int age;


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private VaccinationCenter vaccineCenter;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList = new ArrayList<>();
}
