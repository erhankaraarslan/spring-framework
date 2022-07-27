package com.karaarslan.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karaarslan.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeDAOJpaImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findAll() {

		Query theQuery = entityManager.createQuery("from Employee");

		List<Employee> employess = theQuery.getResultList();

		return employess;
	}

	@Override
	public Employee findById(int theId) {

		Employee employee = entityManager.find(Employee.class, theId);

		return employee;
	}

	@Override
	public void save(Employee theEmployee) {

		// save or update
		Employee dbEmployee = entityManager.merge(theEmployee);

		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {

		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
