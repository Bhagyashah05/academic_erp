package com.bhagya.academics.mapper;

import com.bhagya.academics.dto.DomainRequest;
import com.bhagya.academics.entity.Domain;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class DomainMapper {

    public Domain toDomain( DomainRequest request) {
        return Domain.builder()
                .program(request.program())
                .capacity(request.capacity())
                .qualification(request.qualification())
                .batch(request.batch())
                .build();
    }
}
