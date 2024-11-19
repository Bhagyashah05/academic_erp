package com.bhagya.academics.dto;

public record DomainResponse(
        int domainId,
        String program,
        String batch,
        int capacity,
        String qualification
) {}

