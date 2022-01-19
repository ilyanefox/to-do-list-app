package com.todolist.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Task extends AbstractEntity{

    private String name;

    @ManyToOne
    private Category category;

    public Task() {
    }

    public Task(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
