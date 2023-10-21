package com.enoca.springmvc.dao;

import com.enoca.springmvc.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

public interface EmployeeDAO {

	 List<Employee> getEmployees();

	 void saveEmployee(Employee theEmployee);

	 Employee getEmployee(Integer id);

	void deleteEmployee(Integer id);

	Set<Employee> getEmployersByCompany(Integer id);
	
}
