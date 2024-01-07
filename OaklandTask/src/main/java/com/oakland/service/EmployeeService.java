package com.oakland.service;

import java.util.List;

import com.oakland.entity.Employee;

public interface EmployeeService {

	int registerEmployee(Employee employee);
	
	List<Employee> getALLEmployees();

	Employee loginEmployee(String loginId, String password);

}
