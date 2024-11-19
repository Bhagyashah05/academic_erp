package com.bhagya.academics.controller;

import com.bhagya.academics.dto.UserRequest;
import com.bhagya.academics.service.AdminService;
import com.bhagya.academics.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userservice;
    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid UserRequest request) {
        return ResponseEntity.ok(userservice.createUser(request));
    }
}
