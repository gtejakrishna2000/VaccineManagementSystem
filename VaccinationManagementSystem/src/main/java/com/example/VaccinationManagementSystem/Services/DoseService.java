package com.example.VaccinationManagementSystem.Services;

import com.example.VaccinationManagementSystem.Models.Dose;
import com.example.VaccinationManagementSystem.Models.User;
import com.example.VaccinationManagementSystem.Repository.DoseRepository;
import com.example.VaccinationManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;

    @Autowired
    UserRepository userRepository;

    public String giveDose(String doseID, Integer userId){

        User user = userRepository.findById(userId).get();
        Dose dose = new Dose();
        dose.setDoseId(doseID);
        dose.setUser(user);
        user.setDose(dose);
        userRepository.save(user);
        return "Dose given to User successfully";
    }


}
