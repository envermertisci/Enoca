package com.enoca.springmvc.service;

import com.enoca.springmvc.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface EmployeeService {

	 List<Employee> getEmployees();

	 void saveEmployee(Employee theEmployee);

	 Employee getEmployee(Integer id);

	 void deleteEmployee(Integer id);

	Set<Employee> getEmployersByCompany(final Integer id);

}
