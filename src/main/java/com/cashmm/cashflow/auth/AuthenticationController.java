package com.cashmm.cashflow.auth;

import com.cashmm.cashflow.validate.ValidateUsernameTaken;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final ValidateUsernameTaken usernameTaken;

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        boolean isTaken = usernameTaken.existsByUsername(request);
        if (isTaken) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Tên người dùng đã tồn tại");
        } else {
            return ResponseEntity.ok(authenticationService.register(request));
        }

    }
    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> register(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
