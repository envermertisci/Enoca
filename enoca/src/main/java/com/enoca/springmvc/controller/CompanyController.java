package com.enoca.springmvc.controller;

import com.enoca.springmvc.entity.Company;
import com.enoca.springmvc.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    public List<Company> listCompanies() {
        List<Company> companies = companyService.getCompanies();
        return companies;
    }
    @PostMapping("/create")
    public List<Company> createCompany(@RequestBody Company emp){
        companyService.saveCompany(emp);
        return companyService.getCompanies();
    }
    @PutMapping("/update/{id}")
    public Company updateCompany(@PathVariable(name = "id") Integer id, @RequestBody Company updatedCompany){
        Company company = companyService.getCompany(id);
        company.setCompanyName(updatedCompany.getCompanyName());
        companyService.saveCompany(company);
        return company;
    }
    @DeleteMapping("/delete/{id}")
    public List<Company> deleteCompany(@PathVariable(name = "id") Integer id){
        companyService.deleteCompany(id);
        return companyService.getCompanies();
    }
}
