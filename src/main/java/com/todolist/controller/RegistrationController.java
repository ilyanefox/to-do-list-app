package com.todolist.controller;

import com.todolist.model.Category;
import com.todolist.model.User;
import com.todolist.service.CategoryService;
import com.todolist.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "http://localhost:8080/ta-da-list/login")
    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
//        String tempPass = user.getPwHash();
        User userObj = null;
//        if (tempEmail != null && tempPass != null) {
        if (tempEmail != null) {
//            userObj = registrationService.getUserByEmailAndPassword(tempEmail, tempPass);
            userObj = registrationService.getUserByEmail(tempEmail);
        }
        if (userObj == null) {
            throw new Exception(("User does not exist"));
        }
        return userObj;
    }

    @PostMapping(path="/profile", produces = "text/plain", consumes= "text/html")
        public ResponseEntity<User> addCategory(@RequestBody Category name, User user) throws Exception {
            //need relationship between user and category

            Category category = categoryService.addCategory(name);
            List<Category> categories = new ArrayList<Category>();
            categories.add(category);

//        if (categories.contains(category) ) {
//           throw new Exception(("Category already exists"));
//       }

            user.setCategories(categories);
//        List<Category> categoryObj = (List<Category>) categoryService.addCategory(category);
//
//
//        user.setCategories(categoryObj);
        registrationService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCategory(int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getUserCategories(User user, Category categoryList) {

        List<Category> categories = categoryService.getCategories();
//        User userObj = categoryService.getCategories();
        user.setCategories(categories);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = registrationService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
