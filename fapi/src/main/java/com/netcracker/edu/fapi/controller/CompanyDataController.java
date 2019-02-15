package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CompanyViewModel;
import com.netcracker.edu.fapi.service.CompanyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/companies")
public class CompanyDataController {

    private CompanyDataService companyDataService;

    @Autowired
    public CompanyDataController(CompanyDataService companyDataService) {
        this.companyDataService = companyDataService;
    }

//    @GetMapping
//    public ResponseEntity<List<CompanyViewModel>> getAllCompanies() {
//        return ResponseEntity.ok(companyDataService.getAllCompanies());
//    }
//
//    @PostMapping
//    public ResponseEntity<CompanyViewModel> saveCompany(@Valid @RequestBody CompanyViewModel company) {
//        if (company != null && company.getCompanyId() == null) {
//            return ResponseEntity.ok(companyDataService.saveCompany(company));
//        }
//        return null;
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public void deleteCompany(@PathVariable Long id) {
//        companyDataService.deleteCompany(id);
//    }
}
