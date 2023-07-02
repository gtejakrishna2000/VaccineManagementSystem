package com.example.VaccinationManagementSystem.Repository;

import com.example.VaccinationManagementSystem.Models.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer>{
}
