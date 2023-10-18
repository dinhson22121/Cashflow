package com.cashmm.cashflow.user.controller;

import com.cashmm.cashflow.user.io.PasswordRequest;
import com.cashmm.cashflow.user.io.UserRequest;
import com.cashmm.cashflow.user.io.UserResponse;
import com.cashmm.cashflow.user.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/info")
    public ResponseEntity<UserResponse> loadUserInfo(@RequestBody UserRequest userRequest ){
        return ResponseEntity.ok(userService.loadUserInfo(userRequest));
    }

    @PostMapping("/update")
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest userRequest ){
        return ResponseEntity.ok(userService.updateInfoUser(userRequest));
    }

    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody PasswordRequest passwordRequest, Principal connectedUser){
        userService.changePassword(passwordRequest, connectedUser);
        return ResponseEntity.ok().body("Success");
    }
}
