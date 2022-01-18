package com.todolist.service;

import com.todolist.data.TaskRepository;
import com.todolist.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task) {

        return taskRepository.save(task);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public Task findTaskByCategory(String category) {
        return taskRepository.findTaskByCategory(category);
    }

    public void deleteTask(int id){
        taskRepository.deleteTaskById(id);
    }
}

