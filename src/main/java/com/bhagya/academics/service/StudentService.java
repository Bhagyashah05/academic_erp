package com.bhagya.academics.service;

import com.bhagya.academics.dto.StudentResponse;
import com.bhagya.academics.entity.Student;
import com.bhagya.academics.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class StudentService {
    public final StudentRepo studentRepo;
    public List<StudentResponse> getStudentsByDomain(int domainId) {
        List<Student> students =  studentRepo.findByDomain(domainId);

        return students.stream()
                .map(student -> new StudentResponse(
                        student.getStudentId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getDomain(),
                        student.getCgpa(),
                        student.getEmail(),
                        student.getSpecialisation(),
                        student.getGraduationYear(),
                        student.getPlacementId(),
                        student.getPhotographPath(),
                        student.getRollNumber(),
                        student.getTotalCredits()

                ))
                .collect(Collectors.toList());
    }
}
