package com.todolist.service;

import com.todolist.data.CategoryRepository;
import com.todolist.data.RegistrationRepository;
import com.todolist.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private final RegistrationRepository registrationRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    private CategoryService(RegistrationRepository registrationRepository, CategoryRepository categoryRepository) {
        this.registrationRepository = registrationRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

//    public User getUser(String firstName) {
//        return registrationRepository.findByFirstName(firstName);
//    }
//    public User getCategories(List<User> categories) {
//        return registrationRepository.findAllCategories(categories);
//    }
}
