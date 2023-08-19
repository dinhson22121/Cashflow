package com.cashmm.cashflow.user.service.Impl;

import com.cashmm.cashflow.address.io.AddressResponse;
import com.cashmm.cashflow.user.User;
import com.cashmm.cashflow.user.io.UserRequest;
import com.cashmm.cashflow.user.io.UserResponse;
import com.cashmm.cashflow.user.repository.UserRepository;
import com.cashmm.cashflow.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    public UserResponse loadUserInfo(UserRequest userRequest) {
        User user = userRepository.loadUserInfo(userRequest.getEmail());
        if (user != null) {
            var addresses = user.getAddresses();
            Set<AddressResponse> addressResponses = addresses.stream()
                    .map(address -> AddressResponse.builder()
                            .apartmentNumber(address.getApartmentNumber())
                            .state(address.getState())
                            .city(address.getCity())
                            .postalCode(address.getPostalCode())
                            .priorities(address.getPriorities())
                            .street(address.getStreet())
                            .validFlag(address.getValidFlag())
                            .createAt(address.getCreateAt())
                            .build()
                    ).collect(Collectors.toSet());

            return UserResponse.builder()
                    .email(user.getEmail())
                    .phoneNumber(user.getPhoneNumber())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .addresses(addressResponses)
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
    public void changePassword(UserRequest request) {
        userRepository.changePassword(passwordEncoder.encode(request.getPassword()),request.getEmail());
    }
}
