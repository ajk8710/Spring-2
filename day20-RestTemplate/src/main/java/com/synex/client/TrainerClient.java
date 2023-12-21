package com.synex.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component  // @Component creates a general bean (as compared to @Service or @Repository)
public class TrainerClient {
    
    public JsonNode findTrainerOfStudent(String studentName) {
        System.out.println("Run findTrainerOfStudent");
        
        // RestTemplate can make requests to another project on another port.
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity =  // get reseponseEntity from API of another project on port 8282. (I'm on 8283)
                restTemplate.getForEntity("http://localhost:8282/getTrainerWhoTeachesStudent/" + studentName, Object.class);
        Object obj = responseEntity.getBody();  // get body of responseEntity
        
        ObjectMapper mapper = new ObjectMapper();  // let mapper to convert it to json
        JsonNode returnObj = mapper.convertValue(obj, JsonNode.class);  // JsonNode can represent any json.
        return returnObj;
    }
    
    public JsonNode saveTrainerToOtherProject(JsonNode json) {
        System.out.println("Run saveTrainerToOtherProject");
        
        HttpHeaders headers = new HttpHeaders();  // import HttpHeaders (one from spring package, not java.net package)
        headers.setContentType(MediaType.APPLICATION_JSON);  // header has what content type I'm sending in body
        HttpEntity<String> request = new HttpEntity<>(json.toString(), headers);  // create request as http entity
        
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity =  // post responseEntity by calling post API of another project on port 8282. (I'm on 8283)
                restTemplate.postForEntity("http://localhost:8282/saveTrainer", request, Object.class);
        Object obj = responseEntity.getBody();  // get the body response
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode returnObj = mapper.convertValue(obj, JsonNode.class);
        return returnObj;
    }
    
}
