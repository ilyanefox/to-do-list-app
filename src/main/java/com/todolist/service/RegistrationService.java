package com.todolist.service;

import com.todolist.data.CategoryRepository;
import com.todolist.data.RegistrationRepository;
import com.todolist.model.Category;
import com.todolist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private CategoryRepository categoryRepository;

//    @Autowired
//    private CategoryRepository categoryRepository;

    public User saveUser(User user) {
        return registrationRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return registrationRepository.findByEmail(email);
    }

    public User getUserByEmailAndPassword(String email, String pwHash) {
        return registrationRepository.findByEmailAndPwHash(email, pwHash);
    }

//    public User findCategories(User categories) {
//        return registrationRepository.find();
//    };

//    public Optional<User> findById(int id) {
//        return registrationRepository.findById(id);
//    }
}
