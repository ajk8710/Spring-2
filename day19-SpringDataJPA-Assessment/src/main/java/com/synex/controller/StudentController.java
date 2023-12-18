package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Student;
import com.synex.service.StudentService;

@RestController
public class StudentController {
    
    @Autowired StudentService studentService;
    
    @RequestMapping(value="getStudent/{studentId}", method=RequestMethod.GET)
    public Student getStudent(@PathVariable int studentId) {
        return studentService.findById(studentId);
    }
    
    @RequestMapping(value="getAllStudents", method=RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }
    
    @RequestMapping(value="saveStudent", method=RequestMethod.POST)
    public List<Student> saveStudent(@RequestBody Student student) {
        studentService.save(student);
        return studentService.findAll();  // return updated list (or could return updated student then update this student only on table)
    }
    
    @RequestMapping(value="deleteStudent/{studentId}", method=RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteById(studentId);
    }
    
    @RequestMapping(value="findByName/{studentName}", method=RequestMethod.GET)
    public Student findByName(@PathVariable String studentName) {
        return studentService.findByName(studentName);
    }
    
}
