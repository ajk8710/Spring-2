package com.synex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synex.model.Address;
import com.synex.model.Student;

@RestController
public class StudentController2 {
    
    List<Student> studentList = new ArrayList<>();
    {studentList.add(new Student(0, "potato", 12, new Address(123, "City1", "Prov1", "USA", 123)));}
    {studentList.add(new Student(1, "tomato", 15, new Address(123, "City2", "Prov2", "USA", 345)));}
    {studentList.add(new Student(7, "apple", 17, new Address(123, "City3", "Prov3", "USA", 678)));}
    {studentList.add(new Student(10, "pineapple", 18, new Address(123, "City4", "Prov4", "USA", 910)));}
    {studentList.add(new Student(12, "orange", 20, new Address(123, "City5", "Prov5", "USA", 112)));}
    
    @GetMapping("getStudents2")
    public List<Student> getStudents2() {
        return studentList;
    }
    
    @DeleteMapping("deleteStudent2")
    public List<Student> deleteStudent2(@RequestBody Student student) {
        // Go through studentList. If id match, delete from list.
        for (Student s : studentList) {
            if (s.getId() == student.getId()) {
                // int idx = studentList.indexOf(s);  // not needed
                studentList.remove(s);  // remove matching object
                break;
            }
        }
        return studentList;
    }
    
    @GetMapping("getStudentAdd2")
    public Student getStudentAdd2(@RequestParam int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

}
