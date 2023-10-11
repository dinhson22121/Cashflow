package com.cashmm.cashflow.user.service;

import com.cashmm.cashflow.user.io.PasswordRequest;
import com.cashmm.cashflow.user.io.UserRequest;
import com.cashmm.cashflow.user.io.UserResponse;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface UserService {
    UserResponse loadUserInfo(UserRequest userRequest);
    UserResponse updateInfoUser(UserRequest userRequest);
    void changePassword(PasswordRequest request, Principal connectedUser);
}
