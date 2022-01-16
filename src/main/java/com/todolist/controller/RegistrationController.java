package com.todolist.controller;

import com.todolist.model.Category;
import com.todolist.model.User;
import com.todolist.service.CategoryService;
import com.todolist.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/ta-da-list")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins = "http://localhost:8080/ta-da-list/register")
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        if (tempEmail != null && !"".equals(tempEmail)) {
            User userObj = registrationService.getUserByEmail(tempEmail);
            if (userObj != null) {
                throw new Exception("User with this email already exists");
            }
        }
        return registrationService.saveUser(user);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
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

    @PostMapping("/categories")
    public ResponseEntity<Category> addCategory(@RequestBody Category name, User user) throws Exception {
        //need relationship between user and category

        Category category = categoryService.addCategory(name);
        List<Category> categories = new ArrayList<Category>();
        categories.add(category);

//        if (categories.contains(category) ) {
//           throw new Exception(("Category already exists"));
//       }

        user.setCategories(categories);

        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getUserCategories(User user, Category categoryList) {

        List<Category> categories = categoryService.getCategories();
//        User userObj = categoryService.getCategories();
        user.setCategories(categories);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
