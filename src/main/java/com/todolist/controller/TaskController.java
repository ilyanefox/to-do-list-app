package com.todolist.controller;

import com.todolist.model.Category;
import com.todolist.model.Task;
import com.todolist.service.CategoryService;
import com.todolist.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/task")
    public class TaskController {
        private final TaskService taskService;
        private final CategoryService categoryService;

        public TaskController(TaskService taskService, CategoryService categoryService) {
            this.taskService = taskService;
            this.categoryService = categoryService;
        }
//
//        Not retrieving task list
        @GetMapping("/list")
        public ResponseEntity<List<Task>> getAllTasks () {
            List<Task> tasks = taskService.findAllTasks();
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }

        @GetMapping("/find/{category}")
        public ResponseEntity<Task> getTaskByCategory (@PathVariable("category") Category category) {
            Task task = taskService.findTaskByCategory(category);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }

//        Not saving the category name to the category object
        @PostMapping("/add")
        public ResponseEntity<Task> addTask(@RequestBody Task newTask, Category newCategory, String name) {

//            newCategory.getName();

            Task addTask = taskService.addTask(newTask);
//            newCategory.setName(name);
//            String categoryName = String.valueOf(newTask.getCategory());

//            newCategory.setName(categoryName);
            Category categoryObj = addTask.getCategory();
//            Category categoryObj = categoryService.addCategory(newCategory);
//            newTask.setCategory(name);
            categoryService.addCategory(categoryObj);
            System.out.println(categoryObj);
            return new ResponseEntity<>(addTask, HttpStatus.CREATED);
        }

        @PutMapping("/update")
        public ResponseEntity<Task> updateTask(@RequestBody Task task) {
            Task updateTask = taskService.updateTask(task);
            return new ResponseEntity<>(updateTask, HttpStatus.OK);
        }

//        how to select task to be deleted?
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteTask(@PathVariable("id") int id) {
            taskService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
