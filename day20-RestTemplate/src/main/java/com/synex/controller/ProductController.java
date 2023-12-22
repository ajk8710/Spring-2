package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.synex.client.ProductClient;

@RestController
public class ProductController {
    
    @Autowired ProductClient productClient;
    
    @PostMapping("saveProductToOtherProjectDefault")
    public JsonNode saveProductToOtherProject() {
        // Instead of getting product to save on request body, this method construct default product
        
        // Since this project do not have product class, construct json and send json.
        // json is parsed and received as product on another project's API
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.createObjectNode();
        ((ObjectNode) json).put("id", 1);
        ((ObjectNode) json).put("name", "Default Product");
        ((ObjectNode) json).put("price", 200);

        return productClient.saveProductToOtherProject(json);
    }
    
    @PostMapping("saveProductToOtherProject")
    public JsonNode saveProductToOtherProject(@RequestBody JsonNode json) {  // method overloading
        // This method gets product to save from caller of method

        return productClient.saveProductToOtherProject(json);
    }
    
}
