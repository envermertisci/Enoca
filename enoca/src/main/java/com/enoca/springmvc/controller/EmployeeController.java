package com.enoca.springmvc.controller;

import java.util.List;
import java.util.Set;

import com.enoca.springmvc.entity.Employee;
import com.enoca.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/list")
	public List<Employee> listEmployees() {
		List<Employee> employees = employeeService.getEmployees();
		return employees;			}
	@GetMapping("/list/company/{id}")
	public Set<Employee> getEmployeesByCompany(@PathVariable(name = "id") Integer id) {
		Set<Employee> employees = employeeService.getEmployersByCompany(id);
		return employees;			}
	@PostMapping("/create")
	public List<Employee> createEmployee(@RequestBody Employee emp){
		employeeService.saveEmployee(emp);
		return employeeService.getEmployees();				}
	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable(name = "id") Integer id, @RequestBody Employee updatedEmployee){
		Employee employee = employeeService.getEmployee(id);
		employee.setEmail(updatedEmployee.getEmail());
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employeeService.saveEmployee(employee);
		return employee;  				}
	@DeleteMapping("/delete/{id}")
	public List<Employee> deleteEmployee(@PathVariable(name = "id") Integer id){
		employeeService.deleteEmployee(id);
		return employeeService.getEmployees();
	}
}
