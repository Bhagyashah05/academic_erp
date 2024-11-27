package com.bhagya.academics.service;

import com.bhagya.academics.dto.LoginRequest;
import com.bhagya.academics.dto.LoginResponse;
import com.bhagya.academics.entity.User;
import com.bhagya.academics.exception.UserNotAdmin;
import com.bhagya.academics.exception.UserNotFoundException;
import com.bhagya.academics.exception.WrongPasswordException;
import com.bhagya.academics.helper.JWTHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.bhagya.academics.repo.CustomerRepo;


@Service
@RequiredArgsConstructor
public class AdminService {

    private final CustomerRepo customerRepo;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;


    public LoginResponse login(LoginRequest request) {
        User user = getUser(request.email());
//        if (user == null) {
//            throw new IllegalArgumentException("User not found");
//        }

        if (!user.getRole().equals("Admin")){
            throw new UserNotAdmin("User Not Admin");
        }

        if (!encryptionService.validates(request.password(), user.getPassword())) {
            throw new WrongPasswordException("Wrong Password");
        }
        String token = jwtHelper.generateToken(request.email());
        return new LoginResponse(user.getUser_id(), user.getEmail(), user.getRole(), user.getName(),token);
    }

    private User getUser(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"));
    }
}
