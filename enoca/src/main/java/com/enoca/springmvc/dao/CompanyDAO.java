package com.enoca.springmvc.dao;

import com.enoca.springmvc.entity.Company;

import java.util.List;

public interface CompanyDAO {

     List<Company> getCompanies();

     void saveCompany(Company theCompany);

     Company getCompany(Integer id);

     void deleteCompany(Integer id);
}
