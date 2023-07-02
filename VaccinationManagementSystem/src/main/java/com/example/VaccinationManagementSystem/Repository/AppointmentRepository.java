package com.example.VaccinationManagementSystem.Repository;

import com.example.VaccinationManagementSystem.Models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
}
