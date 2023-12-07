package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synex.model.Address;
import com.synex.model.Student;
import com.synex.service.StudentService;

@RestController
public class StudentController3 {
    
    @Autowired StudentService studentService;
    
    @RequestMapping(value="getAllStudents", method=RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @RequestMapping(value="addStudent3", method=RequestMethod.POST)
    public List<Student> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
    
    @RequestMapping(value="deleteStudent3/{studentId}", method=RequestMethod.DELETE)
    public List<Student> removeStudent(@PathVariable int studentId) {
        return studentService.removeStudent(studentId);
    }
    
    @RequestMapping(value="getStudentAdd3/{studentId}", method=RequestMethod.GET)
    public Address getAddress(@PathVariable int studentId) {
        return studentService.getAddress(studentId);
    }

}
