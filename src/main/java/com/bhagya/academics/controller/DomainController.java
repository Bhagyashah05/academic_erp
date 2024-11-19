package com.bhagya.academics.controller;

import com.bhagya.academics.dto.DomainRequest;
import com.bhagya.academics.dto.DomainResponse;
import com.bhagya.academics.dto.UserRequest;
import com.bhagya.academics.service.DomainService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/domain")
@RequiredArgsConstructor
public class DomainController {
    private final DomainService domainservice;

    @PostMapping
    public ResponseEntity<String> createDomain(@RequestBody DomainRequest request) {
        try {
            return ResponseEntity.ok(domainservice.createDomain(request));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating domain: " + e.getMessage());
        }
    }

    @PutMapping("/{domainId}")
    public ResponseEntity<String> modifyDomain(
            @PathVariable int domainId,
            @RequestBody DomainRequest request) {
        try {
            return ResponseEntity.ok(domainservice.modifyDomain(domainId, request));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error modifying domain: " + e.getMessage());
        }
    }

    @GetMapping("/{domainId}")
    public ResponseEntity<DomainResponse> getDomain(@PathVariable int domainId) {
        try {
            return ResponseEntity.ok(domainservice.getDomain(domainId));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<DomainResponse>> getDomains() {
        try {
            return ResponseEntity.ok(domainservice.getAllDomains());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}



