package com.bhagya.academics.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bhagya.academics.entity.User;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
