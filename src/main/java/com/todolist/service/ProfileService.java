package com.todolist.service;

import com.todolist.data.RegistrationRepository;
import com.todolist.model.Category;
import com.todolist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final RegistrationRepository registrationRepository;

    @Autowired
    private CategoryService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Category> findAllCategories() {
        return registrationRepository.findAll();
    }

}
