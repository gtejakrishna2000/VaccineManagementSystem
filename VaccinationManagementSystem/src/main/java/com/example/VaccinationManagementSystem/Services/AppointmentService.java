package com.example.VaccinationManagementSystem.Services;

import com.example.VaccinationManagementSystem.Dtos.AppointmentDto;
import com.example.VaccinationManagementSystem.Exceptions.DoctorNotFoundException;
import com.example.VaccinationManagementSystem.Exceptions.UserNotFoundException;
import com.example.VaccinationManagementSystem.Models.Appointment;
import com.example.VaccinationManagementSystem.Models.Doctor;
import com.example.VaccinationManagementSystem.Models.User;
import com.example.VaccinationManagementSystem.Repository.AppointmentRepository;
import com.example.VaccinationManagementSystem.Repository.DoctorRepository;
import com.example.VaccinationManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;

    public String bookAppointment(AppointmentDto appointmentDto) throws DoctorNotFoundException,UserNotFoundException{
        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentDto.getDocId());
        if(doctorOptional.isEmpty()){
            throw new DoctorNotFoundException("DoctorId not found");
        }
        Optional<User> userOptional = userRepository.findById(appointmentDto.getUserId());
        if(!userOptional.isPresent()){
            throw new UserNotFoundException("UserId not found");
        }
        Doctor doctor = doctorOptional.get();
        User user = userOptional.get();

        Appointment appointment = new Appointment();

        //Creating the object and setting of its attributes
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setAppointmentTime(appointmentDto.getAppointmentTime());
        //Setting the foreign key attributes
        appointment.setDoctor(doctor);
        appointment.setUser(user);

        doctor.getAppointmentList().add(appointment);
        user.getAppointmentList().add(appointment);

        doctorRepository.save(doctor);
        userRepository.save(user);

        return "Appointment is booked";
    }
}
