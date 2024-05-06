package net.project1.emsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.project1.emsbackend.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

} 
