package com.cashmm.cashflow.validate;


import com.cashmm.cashflow.auth.AuthenticationRequest;
import com.cashmm.cashflow.auth.AuthenticationService;
import com.cashmm.cashflow.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateEmailService {

    public boolean isValidEmail(RegisterRequest request) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(request.getEmail());
    }

    public boolean isValidEmail(AuthenticationRequest request) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        return emailValidator.isValid(request.getEmail());
    }
}
