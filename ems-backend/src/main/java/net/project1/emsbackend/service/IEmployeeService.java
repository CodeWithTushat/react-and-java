package net.project1.emsbackend.service;

import java.util.List;

import net.project1.emsbackend.dto.EmployeeDto;

public interface IEmployeeService {
    EmployeeDto create(EmployeeDto employeeDto);
    
    EmployeeDto getEmployeeById(Integer id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto update(Integer isd, EmployeeDto employeeDto);

    void deleteById(Integer id);
}
