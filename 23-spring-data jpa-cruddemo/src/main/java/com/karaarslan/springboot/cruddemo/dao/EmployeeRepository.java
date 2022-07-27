package com.karaarslan.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karaarslan.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
