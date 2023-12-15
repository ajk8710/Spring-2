package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synex.domain.Trainer17;
import com.synex.service.Trainer17Service;

@RestController
public class Trainer17Controller {
    
    @Autowired Trainer17Service trainer17Service;
    
    @RequestMapping(value="/getTrainerWhoTeachesStudent/{studentName}", method=RequestMethod.GET)
    public List<Trainer17> getTrainerWhoTeachesStudent(@PathVariable String studentName) {
        return trainer17Service.findByStudentList_Name(studentName);
    }
    
    @RequestMapping(value="/getTrainerWhoTeachesStudentNoUnderscore/{studentName}", method=RequestMethod.GET)
    public List<Trainer17> getTrainerWhoTeachesStudentNoUnderscore(@PathVariable String studentName) {
        return trainer17Service.findByStudentListName(studentName);
    }
    
}
