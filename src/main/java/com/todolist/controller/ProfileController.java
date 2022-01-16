package com.todolist.controller;

import com.todolist.service.CategoryService;
import com.todolist.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ProfileController {

    private final CategoryService categoryService;

    private final RegistrationService registrationService;

    public ProfileController(CategoryService categoryService, RegistrationService registrationService) {
        this.categoryService = categoryService;
        this.registrationService = registrationService;
    }

//    @GetMapping("")
//    public ResponseEntity<User> getName(String firstName) {
//        User user = profileService.getName(firstName);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }

//    @GetMapping("/categories")
//    public ResponseEntity<List<Category>> getCategories(List<Category> categories) {
//        List<Category> categoryList = profileService.getCategories(categories);
//        return new ResponseEntity<>(categoryList, HttpStatus.OK);
//    }
//    public ResponseEntity<List<Category>> getCategories(List<Category> categories) {
//        List<Category> categoryList = profileService.getCategories(categories);
//        return new ResponseEntity<>(categoryList, HttpStatus.OK);
//    }

//    @PostMapping("/categories")
//    public ResponseEntity<User> addCategory(@RequestBody User user, Category name) {
//        //need relationship between user and category
//        Category category = profileService.addCategory(name);
//        ArrayList<Category> categories = new ArrayList<>();
//        categories.add(category);
//        user.setCategories(categories);
//        User userObj = registrationService.saveUser(user);
//        return new ResponseEntity<>(userObj, HttpStatus.CREATED);
//    }
//set category to user
//    @GetMapping("/{name}")
//    public ResponseEntity<User> getFirstName (@PathVariable("name") String firstName) {
//        User user = profileService.getUser(firstName);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }

}
