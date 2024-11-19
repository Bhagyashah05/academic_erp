package com.bhagya.academics.service;

import com.bhagya.academics.dto.DomainRequest;
import com.bhagya.academics.dto.DomainResponse;
import com.bhagya.academics.entity.Domain;
import com.bhagya.academics.mapper.CustomerMapper;
import com.bhagya.academics.mapper.DomainMapper;
import com.bhagya.academics.repo.DomainRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DomainService {

    private final DomainMapper domainMapper;
    private final DomainRepo domainrepo;

    public String createDomain(DomainRequest request) {
        try {
            Domain domain = domainMapper.toDomain(request);
            domainrepo.save(domain);
            return "Domain created successfully with ID: " + domain.getDomain_id();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create domain: " + e.getMessage(), e);
        }
    }

    public String modifyDomain(int domainId, DomainRequest request) {
        try {
            Domain existingDomain = domainrepo.findById(domainId)
                    .orElseThrow(() -> new IllegalArgumentException("Domain with ID " + domainId + " not found"));

            if (request.program() != null) {
                existingDomain.setProgram(request.program());
            }
            if (request.batch() != null) {
                existingDomain.setBatch(request.batch());
            }
            if (request.capacity() != -1) {
                existingDomain.setCapacity(request.capacity());
            }
            if (request.qualification() != null) {
                existingDomain.setQualification(request.qualification());
            }

            domainrepo.save(existingDomain);
            return "Domain updated successfully with ID: " + existingDomain.getDomain_id();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid domain update request: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update domain: " + e.getMessage(), e);
        }
    }

    public DomainResponse getDomain(int domainId) {
        try {
            Domain existingDomain = domainrepo.findById(domainId)
                    .orElseThrow(() -> new IllegalArgumentException("Domain with ID " + domainId + " not found"));

            return new DomainResponse(
                    existingDomain.getDomain_id(),
                    existingDomain.getProgram(),
                    existingDomain.getBatch(),
                    existingDomain.getCapacity(),
                    existingDomain.getQualification()
            );
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error retrieving domain: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
        }
    }

    public List<DomainResponse> getAllDomains() {
        try {
            return domainrepo.findAll().stream()
                    .map(domain -> new DomainResponse(
                            domain.getDomain_id(),
                            domain.getProgram(),
                            domain.getBatch(),
                            domain.getCapacity(),
                            domain.getQualification()
                    ))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve all domains: " + e.getMessage(), e);
        }
    }
}
