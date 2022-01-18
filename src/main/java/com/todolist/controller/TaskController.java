package com.todolist.controller;

import com.todolist.model.Task;
import com.todolist.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/employee")
    public class TaskController {
        private final TaskService taskService;

        public TaskController(TaskService taskService) {
            this.taskService = taskService;
        }

        @GetMapping("/all")
        public ResponseEntity<List<Task>> getAllTasks () {
            List<Task> tasks = taskService.findAllTasks();
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }

        @GetMapping("/find/{category}")
        public ResponseEntity<Task> getTaskByCategory (@PathVariable("category") String category) {
            Task task = taskService.findTaskByCategory(category);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<Task> addTask(@RequestBody Task task) {
            Task newTask = taskService.addTask(task);
            return new ResponseEntity<>(newTask, HttpStatus.CREATED);
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
