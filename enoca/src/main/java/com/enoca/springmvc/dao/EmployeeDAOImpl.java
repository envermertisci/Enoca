package com.enoca.springmvc.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.enoca.springmvc.entity.Company;
import com.enoca.springmvc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.loader.custom.sql.SQLCustomQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployees() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void deleteEmployee(final Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Employee book = session.byId(Employee.class).load(id);
		session.delete(book);
	}

	@Override
	public void saveEmployee(final Employee theEmployee) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public Employee getEmployee(final Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Employee theEmployee = currentSession.get(Employee.class, id);
		return theEmployee;
	}

	@Override
	public Set<Employee> getEmployersByCompany(final Integer id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Company company = currentSession.get(Company.class, id);
		return company.getEmployees();
	}


}
