package com.todolist.service;

import com.todolist.data.CategoryRepository;
import com.todolist.data.TaskRepository;
import com.todolist.model.Category;
import com.todolist.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;
    @Autowired
    private final CategoryRepository categoryRepository;

    public TaskService(TaskRepository taskRepository, CategoryRepository categoryRepository) {
        this.taskRepository = taskRepository;
        this.categoryRepository = categoryRepository;
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

    public Task findTaskByCategoryName(String name) {
//        Task task = taskRepository.findTaskByCategoryName(name);
        return taskRepository.findTaskByCategoryName(name);
    }

    public void deleteTask(int id){
        taskRepository.deleteTaskById(id);
    }

//    public Task addCategory(String category) {
//        return taskRepository.save(category);
//    }
}

