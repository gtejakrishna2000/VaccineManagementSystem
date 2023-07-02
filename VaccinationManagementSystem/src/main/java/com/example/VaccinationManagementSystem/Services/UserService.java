package com.example.VaccinationManagementSystem.Services;

import com.example.VaccinationManagementSystem.Dtos.UpdateEmailDto;
import com.example.VaccinationManagementSystem.Models.Dose;
import com.example.VaccinationManagementSystem.Models.User;
import com.example.VaccinationManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String add(User user){
        userRepository.save(user);
        return  "User added Successfully";
    }
    public Date getDate(Integer userId){
        User user = userRepository.findById(userId).get();
        Dose dose = user.getDose();
        return dose.getVaccinationDate();
    }

    public String updateEmail(UpdateEmailDto updatemail) {
          int userid = updatemail.getUserid();
          User user = userRepository.findById(userid).get();
          user.setEmailId(updatemail.getEmailId());
          userRepository.save(user);
          return "current email is modified to new one "+updatemail.getEmailId();
    }

    public User getByEmailId(String email) {
        List<User> userList = userRepository.findAll();
        for(User user : userList){
            if(user.getEmailId().equals(email)){
                return user;
            }
        }

        return null;
    }
}
