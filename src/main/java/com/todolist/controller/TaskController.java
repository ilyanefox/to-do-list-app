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
        public ResponseEntity<List<Task>> getAllEmployees () {
            List<Task> employees = taskService.findAllTasks();
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }

        @GetMapping("/find/{id}")
        public ResponseEntity<Task> getEmployeeById (@PathVariable("id") Long id) {
            Task task = taskService.findTaskById(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<Task> addTask(@RequestBody Task task) {
            Task newTask = taskService.addTask(task);
            return new ResponseEntity<>(newTask, HttpStatus.CREATED);
        }

        @PutMapping("/update")
        public ResponseEntity<Task> updateEmployee(@RequestBody Task task) {
            Task updateTask = taskService.updateTask(task);
            return new ResponseEntity<>(updateTask, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
            taskService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
