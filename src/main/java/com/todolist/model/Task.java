package com.todolist.model;

import org.hibernate.annotations.Cascade;


import javax.persistence.*;

@Entity
public class Task extends AbstractEntity{

    private String name;

//    @ManyToOne
//    @Cascade(CascadeType.SAVE_UPDATE)
//    @JoinColumn(name = "category_id")
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "category_id", referencedColumnName = "id")
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
