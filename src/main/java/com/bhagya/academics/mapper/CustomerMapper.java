package com.bhagya.academics.mapper;

import com.bhagya.academics.dto.UserRequest;
import com.bhagya.academics.entity.User;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public User toCustomer(UserRequest request) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .role(request.role())
                .build();
    }
}
