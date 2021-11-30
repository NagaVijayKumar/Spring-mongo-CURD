package com.vijay.springmongoDBCURD.controllers;

import com.vijay.springmongoDBCURD.models.Employee;
import com.vijay.springmongoDBCURD.repository.EmployeeRepository;
import com.vijay.springmongoDBCURD.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    // Create
    @PostMapping(path = "employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        employee.setId(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        return employeeRepository.save(employee);
    }
    public String CreateEmployee(){
        return "Employee Created Successfully";
    }

    //Update
    @PutMapping(path = "/employees/{id}")
    public String updateEmployee(){
        return "Employee updated Successfully";
    }

    // Read
    @GetMapping(path = "/employees")
    public String getAllEmployees(){
        return "All Employee Details";
    }

    @GetMapping(path = "/employees/{id}")
    public String getEmployee(){
        return "Single Employee";
    }

    //Delete
    @DeleteMapping(path = "/employees/{id}")
    public String deleteEmployee(){
        return "Employee Deleted Successfully";
    }
}
