package com.todolist.service;

import com.todolist.data.CategoryRepository;
import com.todolist.data.RegistrationRepository;
import com.todolist.model.Category;
import com.todolist.model.User;
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

    public Category addCategory(Category categories) {
        return categoryRepository.save(categories);
    }

    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }
//    public User getUser(String firstName) {
//        return registrationRepository.findByFirstName(firstName);
//    }
//    public User getCategories(List<User> categories) {
//        return registrationRepository.findAllCategories(categories);
//    }
}
