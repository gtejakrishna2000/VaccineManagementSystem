package com.example.VaccinationManagementSystem.Services;

import com.example.VaccinationManagementSystem.Dtos.AssociateDoctorDto;
import com.example.VaccinationManagementSystem.Exceptions.DoctorAlreadyExistsException;
import com.example.VaccinationManagementSystem.Exceptions.DoctorNotFoundException;
import com.example.VaccinationManagementSystem.Exceptions.EmailIdEmptyException;
import com.example.VaccinationManagementSystem.Exceptions.VaccinationCenterNotFoundException;
import com.example.VaccinationManagementSystem.Models.Doctor;
import com.example.VaccinationManagementSystem.Models.VaccinationCenter;
import com.example.VaccinationManagementSystem.Repository.DoctorRepository;
import com.example.VaccinationManagementSystem.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private VaccinationCenterRepository vaccinationCenterRepository;


    public String addDoctor(Doctor doctor) throws EmailIdEmptyException,DoctorAlreadyExistsException{
        if(doctor.getEmailId()==null){
            throw new EmailIdEmptyException("Email id is mandatory");
        }

        if(doctorRepository.findByEmailId(doctor.getEmailId())!=null){
            throw new DoctorAlreadyExistsException("Doctor with this emailId already exits.");
        }

        doctorRepository.save(doctor);

        return "Doctor has been added to the database";
    }

    public String associateDoc(AssociateDoctorDto associateDoctorDto)throws DoctorNotFoundException,VaccinationCenterNotFoundException{

        Integer docId = associateDoctorDto.getDoctorId();
        Optional<Doctor> optionalDoctor = doctorRepository.findById(docId);
        if(optionalDoctor.isEmpty()){
            throw new DoctorNotFoundException("DoctorId is not Found");
        }

        Integer vaccineCenterId = associateDoctorDto.getVaccineCenterId();
        Optional<VaccinationCenter> optionalVaccineCenter = vaccinationCenterRepository.findById(vaccineCenterId);
        if(optionalVaccineCenter.isEmpty()){
            throw new VaccinationCenterNotFoundException("VaccineCenterId is not Found");
        }

        Doctor doctor = optionalDoctor.get();

        VaccinationCenter vaccinationCenter = optionalVaccineCenter.get();

        doctor.setVaccineCenter(vaccinationCenter);
        vaccinationCenter.getDoctorList().add(doctor);
        vaccinationCenterRepository.save(vaccinationCenter);
        return "Doctor has been associated to center";
    }

}
