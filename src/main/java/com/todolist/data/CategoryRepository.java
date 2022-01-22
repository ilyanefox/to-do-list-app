package com.todolist.data;

import com.todolist.model.Category;
import com.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
//   Category findCategoryById(int id);
List<Category> findCategoryByName(String name);
//   List<Category> findAll(Category categories);

//   Category findAll(Category categories);
//    public Category findAllCategories(List<Category> categories);
//public Category findAllCategories(Category categories);
}
