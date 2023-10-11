package com.cashmm.cashflow.user.io;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PasswordRequest {
    private String currentPassword;

    private String newPassword;

    private String confirmPassword;
}
