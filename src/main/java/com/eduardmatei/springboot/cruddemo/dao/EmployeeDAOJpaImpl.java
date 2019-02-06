package com.eduardmatei.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import com.eduardmatei.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		// create a query
		Query query =
				entityManager.createQuery("from Employee", Employee.class);
		
		// execute query and get results list
		List<Employee> employees = query.getResultList();
		
		// retrieve employees
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// get employee
		Employee employee =
				entityManager.find(Employee.class, theId);
		// return employee
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// save or update the employee
		Employee dbEmployee = entityManager.merge(employee);
		
		// update with id from db.. so we can get generated id for save/insert
		employee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {
		// delete object with primary key
		Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
		
		query.setParameter("employeeId", theId);
		
		query.executeUpdate();
	}

}
