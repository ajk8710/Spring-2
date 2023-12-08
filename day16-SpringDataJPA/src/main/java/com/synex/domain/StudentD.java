package com.synex.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class StudentD {
    @Id private int id;
    private String name;
    private int age;
    
    @OneToOne
    private AddressD address;
    
    public StudentD() {}
    
    public StudentD(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public StudentD(int id, String name, int age, AddressD address) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public AddressD getAddress() {
        return address;
    }

    public void setAddress(AddressD address) {
        this.address = address;
    }

}
