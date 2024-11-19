package com.bhagya.academics.service;

import com.bhagya.academics.dto.LoginRequest;
import com.bhagya.academics.entity.User;
import com.bhagya.academics.exception.UserNotFoundException;
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


    public String login(LoginRequest request) {
        User user=getUser(request.email());
        if(user== null){
            return "User not found";
        }
        if(!user.getRole().equals("Admin")){
            return "Only Admin can Login";
        }
        if(!encryptionService.validates(request.password(), user.getPassword())) {
            return "Wrong Password or Email";
        }

        return "Done";
    }

    private User getUser( String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow();
    }
}
