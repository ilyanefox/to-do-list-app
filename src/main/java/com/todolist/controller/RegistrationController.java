package com.todolist.controller;

import com.todolist.model.User;
import com.todolist.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ta-da-list")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @CrossOrigin(origins = "http://localhost:8080/ta-da-list/register")
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        if(tempEmail !=null && !"".equals(tempEmail)) {
            User userObj = registrationService.getUserByEmail(tempEmail);
            if (userObj != null) {
                throw new Exception("User with this email already exists");
            }
        }
        User userObj = registrationService.saveUser(user);
        return userObj;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception{
        String tempEmail = user.getEmail();
        String tempPass = user.getPwHash();
        User userObj = null;
        if (tempEmail != null && tempPass != null) {
          userObj = registrationService.getUserByEmailAndPassword(tempEmail, tempPass);
        }
        if (userObj == null) {
            throw new Exception(("User does not exist"));
        }
        return userObj;
    }
}
