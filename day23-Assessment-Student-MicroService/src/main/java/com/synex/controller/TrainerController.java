package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Student;
import com.synex.domain.Trainer;
import com.synex.service.TrainerService;

@RestController
public class TrainerController {
    
    @Autowired TrainerService trainerService;
    
    @RequestMapping(value="saveTrainer", method=RequestMethod.POST)
    public Trainer saveTrainer(@RequestBody Trainer trainer) {
        System.out.println(trainer);  // to print transient address field
        return trainerService.save(trainer);  // address field is not saved in DB since it's transient field
    }
    
    @RequestMapping(value="getStudentList/{trainerName}", method=RequestMethod.GET)
    public List<Student> getStudentList(@PathVariable String trainerName) {
        return trainerService.getStudentList(trainerName);  // address field is not saved in DB since it's transient field
    }
    
}
