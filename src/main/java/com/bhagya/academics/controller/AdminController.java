package com.bhagya.academics.controller;

import com.bhagya.academics.dto.LoginRequest;
import com.bhagya.academics.exception.UserNotFoundException;
import com.bhagya.academics.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    private final AdminService adminservice;

    @PostMapping("auth/admin/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request) {
//        try {
            return ResponseEntity.ok(adminservice.login(request));
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input: " + e.getMessage());
//        } catch (UserNotFoundException e) {
//            return ResponseEntity.status(1).body("An error occurred: " + e.getMessage());
//        }
//        catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
//        }
    }
}
