package com.example.VaccinationManagementSystem.Repository;

import com.example.VaccinationManagementSystem.Models.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
