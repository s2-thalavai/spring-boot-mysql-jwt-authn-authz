package com.sivasankar.spring_boot_mysql_jwt_authn_authz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sivasankar.spring_boot_mysql_jwt_authn_authz.model.entity.Employee;
import com.sivasankar.spring_boot_mysql_jwt_authn_authz.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private final EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public List<Employee> findAll() {
		return repository.findAll();
	}

	public Employee save(Employee employee) {
		return repository.save(employee);
	}

}