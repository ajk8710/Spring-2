package com.synex.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student17 {
    
    @Id private int id;
    private String name;
    private int age;
    
    @ManyToMany
    private List<Trainer17> trainerList;
    
    public Student17() {};
    
    public Student17(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
}
