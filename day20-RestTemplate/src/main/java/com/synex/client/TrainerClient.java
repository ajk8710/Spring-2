package com.synex.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component  // @Component creates a general bean (as compared to @Service or @Repository)
public class TrainerClient {
    
    public JsonNode findTrainerOfStudent(String studentName) {
        System.out.println("Run Rest Client");
        
        // RestTemplate can make requests to another project on another port.
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> responseEntity =  // get reseponseEntity from API of another project on port 8282. (I'm on 8283)
                restTemplate.getForEntity("http://localhost:8282/getTrainerWhoTeachesStudent/" + studentName, Object.class);
        Object obj = responseEntity.getBody();  // get body of responseEntity
        
        ObjectMapper mapper = new ObjectMapper();  // let mapper to convert it to json
        JsonNode returnObj = mapper.convertValue(obj, JsonNode.class);  // JsonNode can represent any json.
        return returnObj;
    }
    
}
