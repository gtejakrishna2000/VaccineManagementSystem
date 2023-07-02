package com.example.VaccinationManagementSystem.Controller;

import com.example.VaccinationManagementSystem.Exceptions.VaccinationCenterNotFoundException;
import com.example.VaccinationManagementSystem.Models.VaccinationCenter;
import com.example.VaccinationManagementSystem.Services.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
    @Autowired
    public VaccinationCenterService vaccinationCenterService;
    @PostMapping("/addVaccineCenter")
    public String addCenter(@RequestBody VaccinationCenter vaccinationCenter){
        try{
            String response = vaccinationCenterService.addCenter(vaccinationCenter);
            return response;
        }
        catch(Exception ex){
            return ex.getMessage();
        }
    }
}
