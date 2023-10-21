package com.enoca.springmvc.service;

import java.util.List;
import java.util.Set;

import com.enoca.springmvc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enoca.springmvc.dao.EmployeeDAO;

@Service
@Qualifier("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(final Employee theEmployee) {
		employeeDAO.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(final Integer id) {
		return employeeDAO.getEmployee(id);
	}

	@Override
	@Transactional
	public void deleteEmployee(final Integer id) {
		employeeDAO.deleteEmployee(id);
	}

	@Override
	@Transactional
	public Set<Employee> getEmployersByCompany(final Integer companyId) {
		return employeeDAO.getEmployersByCompany(companyId);
	}
}





