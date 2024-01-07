package com.oakland.dao;

import java.util.List;

import com.oakland.entity.Employee;

public interface EmployeeDao {

	int registerEmployee(Employee employee);
	
	List<Employee> getAllEmployee();

	Employee loginEmployee(String loginId, String password);

}
