package com.cashmm.cashflow.validate;

import com.cashmm.cashflow.auth.RegisterRequest;
import com.cashmm.cashflow.user.io.UserRequest;
import com.cashmm.cashflow.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateUsernameTaken {
    private final UserRepository userRepository;
    public boolean existsByUsername(RegisterRequest userRequest) {
        return userRepository.existsByEmail(userRequest.getEmail());
    }
    public boolean existsByUsername(UserRequest userRequest) {
        return userRepository.existsByEmail(userRequest.getEmail());
    }
}
