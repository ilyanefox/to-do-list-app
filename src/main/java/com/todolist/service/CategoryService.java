package com.todolist.service;

import com.todolist.data.CategoryRepository;
import com.todolist.data.RegistrationRepository;
import com.todolist.model.Category;
import com.todolist.model.Task;
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

//    public Task addCategory(Task task) {
//        return categoryRepository.save(task);
//    }

    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }
//    public User getUser(String firstName) {
//        return registrationRepository.findByFirstName(firstName);
//    }
//    public User getCategories(List<User> categories) {
//        return registrationRepository.findAllCategories(categories);
//    }
public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
}
