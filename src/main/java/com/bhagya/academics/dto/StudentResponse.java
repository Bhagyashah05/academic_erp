package com.bhagya.academics.dto;

public record StudentResponse(
        int studentId,
        String firstName,
        String lastName,
        int domain,
        float cgpa,
        String email,
        int specialisation,
        String graduationYear,
        int placementId,
        String photographPath,
        String rollNumber,
        int totalCredits
) {}

