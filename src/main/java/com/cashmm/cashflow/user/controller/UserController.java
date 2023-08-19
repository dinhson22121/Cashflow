package com.cashmm.cashflow.user.controller;

import com.cashmm.cashflow.user.User;
import com.cashmm.cashflow.user.io.UserRequest;
import com.cashmm.cashflow.user.io.UserResponse;
import com.cashmm.cashflow.user.service.Impl.UserServiceImpl;
import com.cashmm.cashflow.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody UserRequest userRequest ){
        userService.changePassword(userRequest);
        return ResponseEntity.ok().body("Success full");
    }
}
