package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Company;
import com.netcracker.edu.backend.repository.CompanyRepository;
import com.netcracker.edu.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Company> getAllCompanies() {
        return repository.findAll();
    }

    @Override
    public Optional<Company> getCompany(Long id) {
        return repository.findById(id);
    }

    @Override
    public Company saveCompany(Company company) {
        return repository.save(company);
    }

    @Override
    public void deleteCompany(Long id) {
        repository.deleteById(id);
    }
}
