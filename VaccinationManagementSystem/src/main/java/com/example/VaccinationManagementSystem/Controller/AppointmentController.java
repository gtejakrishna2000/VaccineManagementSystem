package com.example.VaccinationManagementSystem.Controller;

import com.example.VaccinationManagementSystem.Dtos.AppointmentDto;
import com.example.VaccinationManagementSystem.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public String bookAppointment(@RequestBody AppointmentDto appointmentDto){

        try {
            String result = appointmentService.bookAppointment(appointmentDto);
            return result;
        } catch (Exception e){
            return e.getMessage();
        }
    }
}
