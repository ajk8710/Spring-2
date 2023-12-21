package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Student17;
import com.synex.service.Student17Service;

@RestController
public class Student17Controller {
    
    @Autowired Student17Service student17Service;
    
    // @RestController is combination of @Controller & @ResponseBody,
    // and makes sure methods return json response by default. (@Controller returns html)
    // Accessing url getAllStudents on browser returns error if it was @Controller because I'm not returning html, but json list.
    @RequestMapping(value="getAllStudents", method=RequestMethod.GET)
    public List<Student17> getAllStudents() {
        return student17Service.findAll();
    }
    
    @RequestMapping(value="getStudentById/{studentId}", method=RequestMethod.GET)
    public Student17 getStudentById(@PathVariable int studentId) {
        return student17Service.findById(studentId);
    }
    
    // Test following post and delete APIs with PostMan & Spring H2 DB.
    @RequestMapping(value="saveStudent", method=RequestMethod.POST)
    public Student17 saveStudent(@RequestBody Student17 student) {  // Without @RequestBody, postman doesn't accept request body & sends student=null data
        return student17Service.save(student);
    }
    
    // Version using path variable. Ex: deleteStudent/1 without request body on postman.
    @RequestMapping(value="deleteStudent/{studentId}", method=RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int studentId) {
        student17Service.deleteById(studentId);
    }
    
    // Version using request param. EX: deleteStudentByReqParam?studentId=1 without request body on postman.
    @RequestMapping(value="deleteStudentByReqParam", method=RequestMethod.DELETE)
    public void deleteStudentByReqParam(@RequestParam int studentId) {
        student17Service.deleteById(studentId);
    }
    
    @RequestMapping(value="/getStudentsWhoTaughtByTrainer/{trainerName}", method=RequestMethod.GET)
    public List<Student17> getTrainerWhoTeachesStudentNoUnderscore(@PathVariable String trainerName) {
        return student17Service.findByTrainerListTrainerName(trainerName);
    }
    
}
