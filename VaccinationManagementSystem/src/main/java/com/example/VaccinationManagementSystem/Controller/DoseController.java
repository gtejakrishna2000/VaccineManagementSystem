package com.example.VaccinationManagementSystem.Controller;

import com.example.VaccinationManagementSystem.Services.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {
    @Autowired
    DoseService doseService;

    @PostMapping("/giveDose")
    public String giveDose(@RequestParam String doseID, @RequestParam Integer userId){

        return doseService.giveDose(doseID,userId);


    }

}
