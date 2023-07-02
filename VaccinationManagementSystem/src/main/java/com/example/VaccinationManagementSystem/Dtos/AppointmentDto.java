package com.example.VaccinationManagementSystem.Dtos;

import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentDto {

    private Integer docId;

    private Integer userId;

    private Date appointmentDate;

    private LocalTime appointmentTime;
}
