package com.synex.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Transient;

@Entity
public class Trainer17 {
    
    @Id private int id;
    private String trainerName;
    @Transient private String address;  // transient field does not get created/saved into column of table in DB
    
    // Set relationship table name and its column names.
    @JoinTable(name="trainer_student",
        joinColumns = {@JoinColumn(name="trainer_id")},
        inverseJoinColumns = {@JoinColumn(name="student_id")}
    )
    @ManyToMany
    private List<Student17> studentList;
    
    public Trainer17() {}
    
    public Trainer17(int id, String trainerName) {
        this.id = id;
        this.trainerName = trainerName;
    }
    
    public Trainer17(int id, String trainerName, String address) {
        super();
        this.id = id;
        this.trainerName = trainerName;
        this.address = address;
    }

    public Trainer17(int id, String trainerName, List<Student17> studentList) {
        this.id = id;
        this.trainerName = trainerName;
        this.studentList = studentList;
    }

    public Trainer17(int id, String trainerName, String address, List<Student17> studentList) {
        super();
        this.id = id;
        this.trainerName = trainerName;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Student17> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student17> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Trainer [id=" + id + ", trainerName=" + trainerName + ", address=" + address + ", studentList=" + studentList + "]";
    }
    
}
