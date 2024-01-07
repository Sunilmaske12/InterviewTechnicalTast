package com.oakland.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.oakland.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	@Override
	public int registerEmployee(Employee employee) {
		int id = (int) this.hibernateTemplate.save(employee);
		return id;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> allEmployees = this.hibernateTemplate.loadAll(Employee.class);
		return allEmployees;
	}

	
	public Employee loginEmployee(String loginId, final String password) {
		
        final String query = "from Employee where loginId=:loginId and password=:password";
        
        Employee employee = (Employee)this.hibernateTemplate.execute(s->{
        	org.hibernate.query.Query<Employee> q=s.createQuery(query, Employee.class);
        	q.setParameter("loginId", loginId);
        	q.setParameter("password", password);
        	return q.uniqueResult();
        });
        
        
        return employee;
	}

}
