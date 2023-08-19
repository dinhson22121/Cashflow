package com.cashmm.cashflow.user.io;

import com.cashmm.cashflow.address.io.AddressResponse;
import com.cashmm.cashflow.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;
    private String googleId;
    private String picture;
    private Set<AddressResponse> addresses;
}
