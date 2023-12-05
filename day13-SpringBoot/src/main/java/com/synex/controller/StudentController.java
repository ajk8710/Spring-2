package com.synex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.synex.model.Student;

@RestController
public class StudentController {

    List<Student> studentList = new ArrayList<>();

    @GetMapping(value = "getStudent")  // /getStudnets also works (with slash)
    public Student getStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName("Pikachu");
        student.setAge(21);
        return student;  // default is json for req/res exchange in Spring
    }
    
    // return list of students
    @GetMapping(value = "getStudents")
        public List<Student> getStudents() {
        return studentList;
    }
    
    // add a new student then return updated list
    @PostMapping(value = "postStudent")
        public List<Student> postStudent(@RequestBody Student student) {
        studentList.add(student);
        return studentList;
    }

}
