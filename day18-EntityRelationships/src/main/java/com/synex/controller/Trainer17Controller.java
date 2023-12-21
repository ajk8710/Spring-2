package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Trainer17;
import com.synex.service.Trainer17Service;

@RestController
public class Trainer17Controller {
    
    @Autowired Trainer17Service trainer17Service;
    
    @RequestMapping(value="getTrainerById/{trainerId}", method=RequestMethod.GET)
    public Trainer17 getTrainerById(@PathVariable int trainerId) {
        return trainer17Service.findById(trainerId);
    }
    
    @RequestMapping(value="saveTrainer", method=RequestMethod.POST)
    public Trainer17 saveTrainer(@RequestBody Trainer17 trainer) {
        System.out.println(trainer);  // to print transient address field
        return trainer17Service.save(trainer);  // address field is not saved in DB since it's transient field
    }
    
    @RequestMapping(value="/getTrainerWhoTeachesStudent/{studentName}", method=RequestMethod.GET)
    public List<Trainer17> getTrainerWhoTeachesStudent(@PathVariable String studentName) {
        return trainer17Service.findByStudentList_Name(studentName);
    }
    
    @RequestMapping(value="/getTrainerWhoTeachesStudentNoUnderscore/{studentName}", method=RequestMethod.GET)
    public List<Trainer17> getTrainerWhoTeachesStudentNoUnderscore(@PathVariable String studentName) {
        return trainer17Service.findByStudentListName(studentName);
    }
    
}
