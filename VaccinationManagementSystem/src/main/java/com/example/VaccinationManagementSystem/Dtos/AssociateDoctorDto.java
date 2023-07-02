package com.example.VaccinationManagementSystem.Dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AssociateDoctorDto {
    private Integer doctorId;
    private Integer vaccineCenterId;
}
