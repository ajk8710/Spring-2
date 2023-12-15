package com.synex.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Trainer17 {
    
    @Id private int id;
    private String trainerName;
    
    @ManyToMany
    private List<Student17> studentList;
    
    public Trainer17() {}
    
    public Trainer17(int id, String trainerName) {
        this.id = id;
        this.trainerName = trainerName;
    }

    public Trainer17(int id, String trainerName, List<Student17> studentList) {
        this.id = id;
        this.trainerName = trainerName;
        this.studentList = studentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public List<Student17> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student17> studentList) {
        this.studentList = studentList;
    }
    
}
