package com.example.VaccinationManagementSystem.Controller;

import com.example.VaccinationManagementSystem.Dtos.AssociateDoctorDto;
import com.example.VaccinationManagementSystem.Models.Doctor;
import com.example.VaccinationManagementSystem.Services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){

        try {
            String response = doctorService.addDoctor(doctor);
            return response;
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/associateDoc")
    public String associateDoc(@RequestBody AssociateDoctorDto associateDoctorDto){
        try{
            String result = doctorService.associateDoc(associateDoctorDto);
            return result;
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
}
