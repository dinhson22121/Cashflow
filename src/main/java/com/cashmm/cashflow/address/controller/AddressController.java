package com.cashmm.cashflow.address.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @GetMapping
    public ResponseEntity<?> getAdrress(){
        return ResponseEntity.ok("Hello Address");
    }
}
