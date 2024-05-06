package net.project1.emsbackend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.project1.emsbackend.dto.EmployeeDto;
import net.project1.emsbackend.service.IEmployeeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    
    private IEmployeeService iEmployeeService;

    /* 
     * Build add employee api
     */
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = iEmployeeService.create(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Integer employeeId) {
        EmployeeDto employeeDto = iEmployeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(iEmployeeService.getAllEmployees());
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto) {
        EmployeeDto updatedObj = iEmployeeService.update(id, employeeDto);
        return ResponseEntity.ok(updatedObj);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        iEmployeeService.deleteById(id);
        return ResponseEntity.ok("Employee Delete Successfully");
    }
    
}
