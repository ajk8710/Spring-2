package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Student;
import com.synex.domain.Trainer;
import com.synex.service.StudentService;

@RestController
public class StudentController {
    
    @Autowired StudentService studentService;
    
    // @RestController is combination of @Controller & @ResponseBody,
    // and makes sure methods return json response by default. (@Controller returns html)
    // Accessing url getAllStudents on browser returns error if it was @Controller because I'm not returning html, but json list.
    @RequestMapping(value="getAllStudents", method=RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }
    
    // Test following post and delete APIs with PostMan & Spring H2 DB.
    @RequestMapping(value="saveStudent", method=RequestMethod.POST)
    public Student saveStudent(@RequestBody Student student) {  // Without @RequestBody, postman doesn't accept request body & sends student=null data
        return studentService.save(student);
    }
    
    // Version using path variable. Ex: deleteStudent/1 without request body on postman.
    @RequestMapping(value="deleteStudent/{studentId}", method=RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteById(studentId);
    }
    
    // Version using request param. EX: deleteStudentByReqParam?studentId=1 without request body on postman.
    @RequestMapping(value="deleteStudentByReqParam", method=RequestMethod.DELETE)
    public void deleteStudentByReqParam(@RequestParam int studentId) {
        studentService.deleteById(studentId);
    }
    
    @RequestMapping(value="getTrainerList/{studentId}", method=RequestMethod.GET)
    public List<Trainer> getTrainerList(@PathVariable int studentId) {
        return studentService.getTrainerList(studentId);
    }
    
    @RequestMapping(value="/getStudentsWhoTaughtByTrainer/{trainerName}", method=RequestMethod.GET)
    public List<Student> getTrainerWhoTeachesStudentNoUnderscore(@PathVariable String trainerName) {
        return studentService.findByTrainerListTrainerName(trainerName);
    }
    
}
