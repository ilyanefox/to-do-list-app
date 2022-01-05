package com.todolist.service;

import com.todolist.data.RegistrationRepository;
import com.todolist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public User saveUser(User user) {
        return registrationRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return registrationRepository.findByEmail(email);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return registrationRepository.findByEmailAndPassword(email, password);
    }
}
