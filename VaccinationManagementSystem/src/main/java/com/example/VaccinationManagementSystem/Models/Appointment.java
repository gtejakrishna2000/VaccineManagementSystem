package com.example.VaccinationManagementSystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalTime appointmentTime;
    private Date appointmentDate;

    @ManyToOne
    @JoinColumn
    private Doctor doctor;

    @ManyToOne
    @JoinColumn
    private User user;
}
