package com.bhagya.academics.service;

import com.bhagya.academics.dto.UserRequest;
import com.bhagya.academics.mapper.CustomerMapper;
import com.bhagya.academics.repo.CustomerRepo;
import jakarta.validation.Valid;
import com.bhagya.academics.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final CustomerMapper customerMapper;
    private final CustomerRepo userRepo;
    private final EncryptionService encryptionService;

    public String createUser(UserRequest request) {
        User user = customerMapper.toCustomer(request);
        user.setPassword(encryptionService.encode(user.getPassword()));
        userRepo.save(user);
        return "User Created Successfully";
    }
}
