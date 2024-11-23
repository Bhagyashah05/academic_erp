package com.bhagya.academics.service;

import com.bhagya.academics.dto.LoginRequest;
import com.bhagya.academics.dto.LoginResponse;
import com.bhagya.academics.entity.User;
import com.bhagya.academics.exception.UserNotFoundException;
import com.bhagya.academics.helper.JWTHelper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.bhagya.academics.repo.CustomerRepo;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final CustomerRepo customerRepo;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;


    public LoginResponse login(LoginRequest request) {
        User user = getUser(request.email());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (!user.getRole().equals("Admin")) {
            throw new IllegalArgumentException("Only Admin can Login");
        }

        if (!encryptionService.validates(request.password(), user.getPassword())) {
            throw new IllegalArgumentException("Wrong Password or Email");
        }
        String token = jwtHelper.generateToken(request.email());
        return new LoginResponse(user.getUser_id(), user.getEmail(), user.getRole(), user.getName(),token);
    }

    private User getUser( String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow();
    }
}
