package com.todolist.data;

import com.todolist.model.Category;
import com.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
   Task findTaskByCategoryName(String name);
   void deleteTaskById(int id);
}
