package com.synex.config.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class AutoCompleteController {
    
    @GetMapping("getCountry")
    public List<String> getCountry() throws JsonProcessingException {
        List<String> list = new ArrayList<>();
        list.add("USA");
        list.add("United States");
        list.add("Korea");
        list.add("Japan");
        list.add("Canada");
        list.add("Mexico");
        list.add("England");
        list.add("Costa Rica");
        list.add("Congo");
        return list;
    }
    
    @GetMapping("getCountry2/{country}")
    public String getCountry(@PathVariable String country) throws JsonProcessingException {
        List<String> list = new ArrayList<>();
        list.add("USA");
        list.add("United States");
        list.add("Korea");
        list.add("Japan");
        list.add("Canada");
        list.add("Mexico");
        list.add("England");
        list.add("Costa Rica");
        list.add("Congo");
        
        List<String> response = new ArrayList<>();
        for(String str: list) {  // filter out string that contains country
            if(str.contains(country)) {  // This does not ignore case. In practice, it should ignore case to be user friendly.
                response.add(str);
            }
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonArray = objectMapper.writeValueAsString(response);
        return jsonArray;
    }
}
