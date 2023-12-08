package com.cashmm.cashflow.auth;

import com.cashmm.cashflow.address.Address;
import com.cashmm.cashflow.config.JwtService;
import com.cashmm.cashflow.user.Role;
import com.cashmm.cashflow.user.User;
import com.cashmm.cashflow.user.repository.UserRepository;
import com.cashmm.cashflow.validate.ValidateEmailService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ValidateEmailService validateEmailService;

    private final String SUCCESS = "Success";
    @Transactional
    public AuthenticationResponse register(RegisterRequest request) {
        if (!validateEmailService.isValidEmail(request)){
            return AuthenticationResponse.builder()
                    .message("Invalid email"+request.getEmail())
                    .build();
        }

        Address address = new Address();
        address.setApartmentNumber(request.getAddress().getApartmentNumber());
        address.setCity(request.getAddress().getCity());
        address.setState(request.getAddress().getState());
        address.setPostalCode(request.getAddress().getPostalCode());
        address.setStreet(request.getAddress().getStreet());
        address.setValidFlag(request.getAddress().getValidFlag());
        address.setPriorities(request.getAddress().getPriorities());
        address.setCreateAt(new Timestamp(System.currentTimeMillis()));

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .phoneNumber(request.getPhoneNumber())
                .createAt(new Timestamp(System.currentTimeMillis()))
                .build();

        user.setAddress(address);
        address.setUser(user);

        userRepository.saveAndFlush(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .message(SUCCESS)
                .token(jwtToken).build();
    }
    @Transactional
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        if (!validateEmailService.isValidEmail(request)){
            return AuthenticationResponse.builder()
                    .message("Invalid email"+request.getEmail())
                    .build();
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),request.getPassword()
        ));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .message(SUCCESS)
                .token(jwtToken).build();
    }
}
