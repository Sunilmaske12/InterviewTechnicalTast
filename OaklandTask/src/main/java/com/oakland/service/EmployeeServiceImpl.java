package com.oakland.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oakland.dao.EmployeeDao;
import com.oakland.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public int registerEmployee(Employee employee) {
		int id = employeeDao.registerEmployee(employee);
		return id;
	}

	@Override
	public List<Employee> getALLEmployees() {
		List<Employee> allEmployees = this.employeeDao.getAllEmployee();
		return allEmployees;
	}

	@Override
	public List<Employee> getALLEmployeesExceptCurrent(Employee employee) {
		List<Employee> allEmployees = this.employeeDao.getAllEmployee();
			
		 List<Employee> newEmployees = new ArrayList<>();
		 for(Employee emp:allEmployees) {
			 if(employee.getId() != emp.getId()) {
				 newEmployees.add(emp);
			 }
		 }
		return newEmployees;
	}

	
	@Override
	public Employee loginEmployee(String loginId, String password) {
		Employee employee = this.employeeDao.loginEmployee(loginId, password);
		return employee;
	}

}
