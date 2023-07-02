package com.example.VaccinationManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vaccination_center")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VaccinationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vaccineCenterId;
    private String address;
    private LocalTime opentime;
    private LocalTime closetime;
    private String name;
    private List<Doctor> doctorsList = new ArrayList<>();
    @OneToMany(mappedBy = "vaccineCenter",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Doctor> doctorList = new ArrayList<>();
}
