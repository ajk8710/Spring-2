package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.synex.client.TrainerClient;
import com.synex.domain.Trainer17;
import com.synex.service.Trainer17Service;

@RestController
public class Trainer17Controller {
    
/*
For Testing on H2 DB.
H2 creates columns of a table in alphabetical order. i.e. (age, id, name), (student_id, trainer_id). Or maybe double, int, string.
Run below SQL queries on other project's H2 DB.

insert into student17 values (21, 1, 's1');
insert into student17 values (22, 2, 's2');
insert into trainer17 values (3, 't3');
insert into trainer17 values (4, 't4');
insert into trainer_student values (1, 3);
insert into trainer_student values (2, 3);
insert into trainer_student values (1, 4);
*/
    
    @Autowired Trainer17Service trainer17Service;
    @Autowired TrainerClient trainerClient;
    
    @RequestMapping(value="/getTrainerWhoTeachesStudent/{studentName}", method=RequestMethod.GET)
    public List<Trainer17> getTrainerWhoTeachesStudent(@PathVariable String studentName) {
        return trainer17Service.findByStudentList_Name(studentName);
    }
    
    @RequestMapping(value="/getTrainerWhoTeachesStudentNoUnderscore/{studentName}", method=RequestMethod.GET)
    public List<Trainer17> getTrainerWhoTeachesStudentNoUnderscore(@PathVariable String studentName) {
        return trainer17Service.findByStudentListName(studentName);
    }
    
    // version using request param (spring query param)
    // http://localhost:8283/getTrainerWhoTeachesStudentReqParm?studentName=s1
    @RequestMapping(value="/getTrainerWhoTeachesStudentReqParm", method=RequestMethod.GET)
    public List<Trainer17> getTrainerWhoTeachesStudentReqParm(@RequestParam String studentName) {
        return trainer17Service.findByStudentListName(studentName);
    }
    
    // Getting data from another project's H2 on port 8282. (I'm on port 8283)
    @RequestMapping(value="/getTrainerFromOtherProj/{studentName}", method=RequestMethod.GET)
    public JsonNode getTrainerFromOtherProj(@PathVariable String studentName) {
        return trainerClient.findTrainerOfStudent(studentName);
    }
    
    // Posting data to another project's H2 on port 8282. (I'm on port 8283)
    // sending jsonNode, not trainer, because trainer technically is entity of another project. (i.e. cannot import trainer class)
    @RequestMapping(value="saveTrainerToOtherProject", method=RequestMethod.POST)
    public JsonNode saveTrainerToOtherProject(@RequestBody JsonNode jsonNode) {
        return trainerClient.saveTrainerToOtherProject(jsonNode);
    }
    
    @RequestMapping(value="saveTrainerToOtherProjectAlsoSendAddress", method=RequestMethod.POST)
    public JsonNode saveTrainerToOtherProjectAlsoSendAddress(@RequestBody JsonNode jsonNode) {
        // ObjectMapper mapper = new ObjectMapper();  // could convert to json if request body was not json.
        // JsonNode json = mapper.createObjectNode();
        ((ObjectNode) jsonNode).put("address", "New York");  // ObjectNode.put method can add extra contents to body of json.
        return trainerClient.saveTrainerToOtherProject(jsonNode);
    }
    
}
