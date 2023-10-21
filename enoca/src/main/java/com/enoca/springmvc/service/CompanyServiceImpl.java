package com.enoca.springmvc.service;

import com.enoca.springmvc.dao.CompanyDAO;
import com.enoca.springmvc.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CompanyServiceImpl implements  CompanyService{

    @Autowired
    private CompanyDAO CompanyDAO;

    @Override
    @Transactional
    public List<Company> getCompanies() {
        return CompanyDAO.getCompanies();
    }

    @Override
    @Transactional
    public void saveCompany(final Company theCompany) {
        CompanyDAO.saveCompany(theCompany);
    }

    @Override
    @Transactional
    public Company getCompany(final Integer id) {
        return CompanyDAO.getCompany(id);
    }

    @Override
    @Transactional
    public void deleteCompany(final Integer id) {
        CompanyDAO.deleteCompany(id);
    }
}
