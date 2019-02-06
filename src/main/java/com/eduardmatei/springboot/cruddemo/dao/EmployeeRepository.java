package com.eduardmatei.springboot.cruddemo.dao;

import com.eduardmatei.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
