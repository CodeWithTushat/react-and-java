package net.project1.emsbackend.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.project1.emsbackend.dto.EmployeeDto;
import net.project1.emsbackend.entity.Employee;
import net.project1.emsbackend.exceptions.ResourceNotFoundException;
import net.project1.emsbackend.mapper.EmployeeMapper;
import net.project1.emsbackend.repository.IEmployeeRepository;
import net.project1.emsbackend.service.IEmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService    {

    private IEmployeeRepository iEmployeeRespository;

    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee employeeNew = iEmployeeRespository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employeeNew);
    }

    @Override
    public EmployeeDto getEmployeeById(Integer id) {
        Employee employee = hasEmployee(id);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = iEmployeeRespository.findAll();
        List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();

        /* 
        Also do this by streams
        for(Employee emp: employees){
            employeeDtos.add(EmployeeMapper.mapToEmployeeDto(emp));
        } */

        employeeDtos = employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());

        return employeeDtos;
    }

    @Override
    public EmployeeDto update(Integer id, EmployeeDto employeeDto) {
        Employee employee = hasEmployee(id);
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());

        Employee updateEmployee = iEmployeeRespository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployee);
    }

    private Employee hasEmployee(Integer id) {
        Employee employee = iEmployeeRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee is not exists with given id: "+ id));
        return employee;
    }

    @Override
    public void deleteById(Integer id) {
        Employee employee = hasEmployee(id);
        iEmployeeRespository.delete(employee);
    }
    
}
