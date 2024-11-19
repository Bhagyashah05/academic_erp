package com.bhagya.academics;

import com.bhagya.academics.configuration.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class AcademicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademicsApplication.class, args);
    }

}
