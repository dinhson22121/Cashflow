package com.cashmm.cashflow.address;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello Address");
    }
}
