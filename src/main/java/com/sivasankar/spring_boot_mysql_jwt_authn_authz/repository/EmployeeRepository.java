package com.sivasankar.spring_boot_mysql_jwt_authn_authz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivasankar.spring_boot_mysql_jwt_authn_authz.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}