package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.AddressD;
import com.synex.domain.StudentD;
import com.synex.service.StudentService;

@RestController
public class StudentController3 {
    
    @Autowired StudentService studentService;
    
    @RequestMapping(value="getAllStudents", method=RequestMethod.GET)
    public List<StudentD> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @RequestMapping(value="addStudent3", method=RequestMethod.POST)
    public List<StudentD> addStudent(@RequestBody StudentD student) {
        studentService.addStudent(student);
        return studentService.getAllStudents();
    }
    
    @RequestMapping(value="deleteStudent3/{studentId}/{addressId}", method=RequestMethod.DELETE)
    public void removeStudent(@PathVariable int studentId, @PathVariable int addressId) {
        studentService.removeStudent(studentId, addressId);
    }
    
    @RequestMapping(value="getStudentAdd3/{studentId}", method=RequestMethod.GET)
    public AddressD getAddress(@PathVariable int studentId) {
        return studentService.getAddress(studentId);
    }

}
