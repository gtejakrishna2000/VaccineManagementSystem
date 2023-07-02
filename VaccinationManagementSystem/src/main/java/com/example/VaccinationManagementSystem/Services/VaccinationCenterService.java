package com.example.VaccinationManagementSystem.Services;

import com.example.VaccinationManagementSystem.Exceptions.VaccinationCenterAddressNotFoundException;
import com.example.VaccinationManagementSystem.Models.VaccinationCenter;
import com.example.VaccinationManagementSystem.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public String addCenter(VaccinationCenter vaccinationCenter) throws VaccinationCenterAddressNotFoundException{
        if(vaccinationCenter.getAddress() == null){
            throw new VaccinationCenterAddressNotFoundException("Vaccine Center Address is Empty");
        }
        vaccinationCenterRepository.save(vaccinationCenter);
        return "Vaccine Center added at location"+vaccinationCenter.getAddress();
    }
}
