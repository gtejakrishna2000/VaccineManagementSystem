package com.example.VaccinationManagementSystem.Controller;

import com.example.VaccinationManagementSystem.Dtos.UpdateEmailDto;
import com.example.VaccinationManagementSystem.Models.User;
import com.example.VaccinationManagementSystem.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String add(@RequestBody User user){
        return userService.add(user);
    }
    @GetMapping("/getVaccinationDate")
    public Date getDate(@RequestParam("userID") Integer userid){
        return userService.getDate(userid);
    }
    @PutMapping("/updateEmail")
    public String updateEmail(@RequestBody UpdateEmailDto updatemail){

        return userService.updateEmail(updatemail);
    }
    @GetMapping("/getByEmailId/{EmailID}")
    public User getByEmailId(@PathVariable("EmailID")String email){
        return userService.getByEmailId(email);
    }
}
