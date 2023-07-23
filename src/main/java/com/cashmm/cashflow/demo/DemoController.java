package com.cashmm.cashflow.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DemoController {
    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello from secured ");
    }
}
