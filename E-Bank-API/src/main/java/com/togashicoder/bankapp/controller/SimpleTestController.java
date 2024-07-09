package com.togashicoder.bankapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleTestController {

    @GetMapping("/simpletest")
    public ResponseEntity<String> simpleTest() {
        return ResponseEntity.ok("Simple test successful");
    }
}