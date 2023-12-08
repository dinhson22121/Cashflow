package com.cashmm.cashflow.user.service.impl;

import com.cashmm.cashflow.address.Address;
import com.cashmm.cashflow.address.io.AddressResponse;
import com.cashmm.cashflow.user.User;
import com.cashmm.cashflow.user.io.PasswordRequest;
import com.cashmm.cashflow.user.io.UserRequest;
import com.cashmm.cashflow.user.io.UserResponse;
import com.cashmm.cashflow.user.repository.UserRepository;
import com.cashmm.cashflow.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    @Override
    public User loadUserInfo(UserRequest userRequest) {
        Optional<User> userOptional = userRepository.findByEmail(userRequest.getEmail());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Address address = new Address();
            address.setId(user.getAddress().getId());
            address.setApartmentNumber(user.getAddress().getApartmentNumber());
            address.setCity(user.getAddress().getCity());
            address.setState(user.getAddress().getState());
            address.setPostalCode(user.getAddress().getPostalCode());
            address.setStreet(user.getAddress().getStreet());
            address.setValidFlag(user.getAddress().getValidFlag());
            address.setPriorities(user.getAddress().getPriorities());
            address.setCreateAt(new Timestamp(System.currentTimeMillis()));
            return User.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .phoneNumber(user.getPhoneNumber())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .address(address)
                    .role(user.getRole())
                    .googleId(user.getGoogleId())
                    .picture(user.getPicture())
                    .build();

        }
        return null;
    }
    @Transactional
    @Override
    public UserResponse updateInfoUser(UserRequest userRequest) {
        Optional<User> userOptional = userRepository.findByEmail(userRequest.getEmail());
        if (userOptional.isPresent()) {
            var user = userOptional.get();


        }
        return null;
    }

    @Transactional
    @Override
    public void changePassword(PasswordRequest request, Principal connectedUser) {
        var user= (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())){
            throw new IllegalStateException("Wrong Password");
        }
        if (!request.getNewPassword().equals(request.getConfirmPassword())){
            throw new IllegalStateException("Password are not the same");
        }
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }
}
