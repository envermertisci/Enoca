package com.enoca.springmvc.dao;

import com.enoca.springmvc.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Company> getCompanies() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Company> cq = cb.createQuery(Company.class);
        Root<Company> root = cq.from(Company.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteCompany( final Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Company book = session.byId(Company.class).load(id);
        session.delete(book);
    }

    @Override
    public void saveCompany(final Company theCompany) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theCompany);
    }

    @Override
    public Company getCompany(final Integer id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Company theCompany = currentSession.get(Company.class, id);
        return theCompany;
    }
}
