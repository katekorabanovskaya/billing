package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Company;
import com.netcracker.edu.backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/companies")
public class CompanyController {

    private CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Company> getAllCompanies() {
        return service.getAllCompanies();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Company> getCompany(@PathVariable(name = "id") Long id) {
        Optional<Company> company = service.getCompany(id);
        if(company.isPresent()) {
            return ResponseEntity.ok(company.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Company saveCompany(@RequestBody Company company) {
        return service.saveCompany(company);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCompany(@PathVariable(name = "id") Long id) {
        service.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}
