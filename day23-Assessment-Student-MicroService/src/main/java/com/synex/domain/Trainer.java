package com.synex.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Trainer23")
public class Trainer {
    
    @Id private int id;
    
    private String name;
    
    // Set relationship table name and its column names.
    @JoinTable(name="trainer_student",
        joinColumns = {@JoinColumn(name="trainer_id")},
        inverseJoinColumns = {@JoinColumn(name="student_id")}
    )
    @ManyToMany
    @JsonIgnore
    private List<Student> studentList;
    
    public Trainer() {}

    public Trainer(int id, String name, List<Student> studentList) {
        super();
        this.id = id;
        this.name = name;
        this.studentList = studentList;
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    
}
