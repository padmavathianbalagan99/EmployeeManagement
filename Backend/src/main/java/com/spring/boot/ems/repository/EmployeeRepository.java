package com.spring.boot.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.ems.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
}
