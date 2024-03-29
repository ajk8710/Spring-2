package com.synex.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Student23")
public class Student {
    
    @Id private int id;
    
    private String name;
    
    private int age;
    
    @ManyToMany(mappedBy="studentList")
    private List<Trainer> trainerList;
    
    public Student() {}

    public Student(int id, String name, int age, List<Trainer> trainerList) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.trainerList = trainerList;
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

    public List<Trainer> getTrainerList() {
        return trainerList;
    }

    public void setTrainerList(List<Trainer> trainerList) {
        this.trainerList = trainerList;
    }
    
}
