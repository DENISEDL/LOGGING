package com.example.logging1.controller;

import com.example.logging1.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BacisController {
    @Autowired
    private BasicService basicService;
    private static final Logger LOGGER = LoggerFactory.getLogger(BacisController.class);

    @GetMapping("/")
    public ResponseEntity<String> getHello(){
        String saluto = "Welcome";
        LOGGER.info("Messaggio di saluto");
        return ResponseEntity.ok().body(saluto);
    }
    @GetMapping("/exp")
    public ResponseEntity<String> getExponent(){
        LOGGER.info("Calcolo");
        return ResponseEntity.ok().body(String.valueOf(basicService.exponent()));
    }
    @GetMapping("/get-errors")
    public ResponseEntity<String> getDebug(){
        LOGGER.error("Errore");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
    }
}
