package com.enoca.springmvc.service;

import com.enoca.springmvc.entity.Company;

import java.util.List;

public interface CompanyService {

     List<Company> getCompanies();

     void saveCompany(Company theCompany);

     Company getCompany(Integer id);

     void deleteCompany(Integer id);
}
