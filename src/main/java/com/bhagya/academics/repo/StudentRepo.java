package com.bhagya.academics.repo;

import com.bhagya.academics.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByDomain(int domainId);
}
