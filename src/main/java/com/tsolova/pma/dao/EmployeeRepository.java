package com.tsolova.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tsolova.pma.entities.Employee;
import com.tsolova.pma.entities.Project;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Override
	public List<Employee> findAll();
}
