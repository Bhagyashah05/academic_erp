package com.bhagya.academics.controller;

import com.bhagya.academics.dto.LoginRequest;
import com.bhagya.academics.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminservice;

    @PostMapping("auth/admin/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request){
        return ResponseEntity.ok(adminservice.login(request));
    }
}
