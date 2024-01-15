package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.synex.client.StudentClient;

@RestController
public class StudentController {
    
    @Autowired StudentClient studentClient;
    
    @GetMapping("getAllStudents")
    public JsonNode getAllStudents() {
        return studentClient.getAllStudents();
    }
    
    @GetMapping("getTrainerList/{studentId}")
    public JsonNode getTrainerList(@PathVariable int studentId) {
        return studentClient.getTrainerList(studentId);
    }
    
}
