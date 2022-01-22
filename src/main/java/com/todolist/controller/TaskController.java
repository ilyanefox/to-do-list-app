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
        public ResponseEntity<List<Task>> getAllTasks() {
            List<Task> tasks = taskService.findAllTasks();
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }
//      Not done yet
        @GetMapping("/list/{category}")
        public ResponseEntity<Task> getTaskByCategory(@PathVariable("category") Category category, Task task) {
            String categoryName = String.valueOf(category.getName());
            Task getTask = taskService.findTaskByCategoryName(categoryName);
            return new ResponseEntity<>(getTask, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<Task> addTask(@RequestBody Task newTask, Category newCategory, String name) {

            Task addTask = taskService.addTask(newTask);
            Category categoryObj = addTask.getCategory();
            // do I need this?
//            categoryService.addCategory(categoryObj);
            return new ResponseEntity<>(addTask, HttpStatus.CREATED);
        }
//      Not done yet
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
